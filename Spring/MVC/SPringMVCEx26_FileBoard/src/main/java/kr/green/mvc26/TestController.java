package kr.green.mvc26;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.mvc26.service.TestService;
import kr.green.mvc26.vo.TestVO;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/test")
	public String test(Model model, 
			@RequestParam(required = false) Integer num1,
			@RequestParam(required = false) Integer num2) {
		num1 = (num1==null) ?  22: num1;
		num2 = (num2==null) ?  33: num2;

		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("today", testService.selectToday());
		model.addAttribute("sum", testService.selectSum(num1, num2));
		model.addAttribute("mul", testService.selectMul(num1, num2));

		TestVO testVO = new TestVO();
		testVO.setNum1(num1);
		testVO.setNum2(num2);
		model.addAttribute("vo", testService.selectVO(testVO));
		
		return "test";
	}
	
	@RequestMapping(value = "/test/uploadForm")
	public String uploadForm() {
		return "uploadForm"; // 폼만띄운다.
	}
	
	// GET방식 요청이면 uploadForm으로 보내버린다.
	@RequestMapping(value = "/test/uploadOk", method = RequestMethod.GET)
	public String uploadOkGet() {
		return "redirect:/uploadForm";
	}
	
	// POST방식 요청이면 파일 저장을 수행한다.
	@RequestMapping(value = "/test/uploadOk", method = RequestMethod.POST)
	public String uploadOkPost(HttpServletRequest request, MultipartFile file, Model model) {
		log.info("{}의 uploadOkPost 호출!!!!", this.getClass().getName());
		// 절대 경로 구하기
		@SuppressWarnings("deprecation")
		String realPath = request.getRealPath("upload");
		// 설명 받기
		String content = request.getParameter("content"); 
		// 파일은 MultipartFile 객체가 받아준다.
		if(file!=null && file.getSize()>0) { // 파일이 존재 한다면
			try {
				// 저장이름
				String saveName = UUID.randomUUID() + "_" + file.getOriginalFilename();
				// 저장
				File target = new File(realPath, saveName);
				FileCopyUtils.copy(file.getBytes(), target);
				
				model.addAttribute("saveName", saveName);
				model.addAttribute("originalName", file.getOriginalFilename());
				model.addAttribute("fileSize", file.getSize());
				model.addAttribute("contentType", file.getContentType());
				model.addAttribute("folder", realPath);
				model.addAttribute("content", content);
				return "uploadOk";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/uploadForm";	
	}

	@RequestMapping(value = "/test/download")
	public ModelAndView download(@RequestParam HashMap<Object, Object> params, ModelAndView mv) {
		String ofileName = (String) params.get("of"); // 원본이름
		String sfileName = (String) params.get("sf"); // 저장이름
		mv.setViewName("downloadView");
		mv.addObject("ofileName", ofileName);
		mv.addObject("sfileName", sfileName);
		return mv;
	}
}
