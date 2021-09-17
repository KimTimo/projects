package kr.green.mvc26;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.green.mvc26.service.FileBoardService;
import kr.green.mvc26.vo.CommVO;
import kr.green.mvc26.vo.FileBoardFileVO;
import kr.green.mvc26.vo.FileBoardVO;
import kr.green.mvc26.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileBoardController {
	@Autowired
	private FileBoardService fileBoardService;
	
	@RequestMapping(value = "/board/list")
	public String selectList(@ModelAttribute CommVO commVO, Model model) {
		PagingVO<FileBoardVO> pv = fileBoardService.selectList(commVO);
		model.addAttribute("pv", pv);
		model.addAttribute("cv", commVO);
		return "list";
	}
	// 입력폼 띄우기
	@RequestMapping(value = "/board/insertForm")
	public String insertForm(@ModelAttribute CommVO commVO, Model model) {
		model.addAttribute("cv", commVO);
		return "insertForm";
	}
	// 저장하기
	@RequestMapping(value = "/board/insertOk", method = RequestMethod.GET)
	public String insertOkGet() {
		return "redirect:/board/list";
	}
	@RequestMapping(value = "/board/insertOk", method = RequestMethod.POST)
	public String insertOkPost(
			@ModelAttribute CommVO commVO,
			@ModelAttribute FileBoardVO fileBoardVO, 
			MultipartHttpServletRequest request, Model model) {
		// 일단 VO로 받고
		fileBoardVO.setIp(request.getRemoteAddr()); // 아이피 추가로 넣어주고 
		log.info("{}의 insertOkPost 호출 : {}", this.getClass().getName(), commVO + "\n" + fileBoardVO);

		// 넘어온 파일 처리를 하자
		List<FileBoardFileVO> fileList = new ArrayList<>(); // 파일 정보를 저장할 리스트
		
		List<MultipartFile> multipartFiles = request.getFiles("upfile"); // 넘어온 파일 리스트
		if(multipartFiles!=null && multipartFiles.size()>0) {  // 파일이 있다면
			for(MultipartFile multipartFile : multipartFiles) {
				if(multipartFile!=null && multipartFile.getSize()>0 ) { // 현재 파일이 존재한다면
					FileBoardFileVO fileBoardFileVO = new FileBoardFileVO(); // 객체 생성하고
					// 파일 저장하고
					try {
						// 저장이름
						String realPath = request.getRealPath("upload");
						String saveName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
						// 저장
						File target = new File(realPath, saveName);
						FileCopyUtils.copy(multipartFile.getBytes(), target);
						// vo를 채우고
						fileBoardFileVO.setOriName(multipartFile.getOriginalFilename());
						fileBoardFileVO.setSaveName(saveName);
						// 리스트에 추가하고
						fileList.add(fileBoardFileVO); 
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		fileBoardVO.setFileList(fileList);
		// 서비스를 호출하여 저장을 수행한다.
		fileBoardService.insert(fileBoardVO);
		
		return "redirect:/board/list?p=1&s=" + commVO.getPageSize() + "&b=" + commVO.getBlockSize();
	}
	
	@RequestMapping(value = "/board/download")
	public ModelAndView download(@RequestParam HashMap<Object, Object> params, ModelAndView mv) {
		String ofileName = (String) params.get("of"); // 원본이름
		String sfileName = (String) params.get("sf"); // 저장이름
		mv.setViewName("downloadView");
		mv.addObject("ofileName", ofileName);
		mv.addObject("sfileName", sfileName);
		return mv;
	}
	
}
