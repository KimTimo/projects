package kr.green.mvc24;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.green.mvc24.service.FileService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	// 설정파일에 저장되어있는 String 객체 얻기
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/uploadForm")
	public String uploadForm() {
		return "uploadForm"; // 폼만띄운다.
	}
	
	// GET방식 요청이면 uploadForm으로 보내버린다.
	@RequestMapping(value = "/uploadOk", method = RequestMethod.GET)
	public String uploadOkGet() {
		return "redirect:/uploadForm";
	}
	
	// POST방식 요청이면 파일 저장을 수행한다.
	@RequestMapping(value = "/uploadOk", method = RequestMethod.POST)
	public String uploadOkPost(HttpServletRequest request, MultipartFile file, Model model) {
		log.info("{}의 uploadOkPost 호출!!!!", this.getClass().getName());
		// 절대 경로 구하기
		String realPath = request.getRealPath(uploadPath);
		// 설명 받기
		String content = request.getParameter("content"); 
		// 파일은 MultipartFile 객체가 받아준다.
		if(file!=null && file.getSize()>0) { // 파일이 존재 한다면
			try {
				String saveName = FileService.uploadFile(realPath, file.getOriginalFilename(), file.getBytes());
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
	
	@RequestMapping(value = "/multiUploadForm")
	public String multiUploadForm() {
		return "multiUploadForm"; // 폼만띄운다.
	}

	// GET방식 요청이면 uploadForm으로 보내버린다.
	@RequestMapping(value = "/multiUploadOk", method = RequestMethod.GET)
	public String multiUploadOkGget() {
		return "redirect:/multiUploadForm";
	}
	
	// POST방식 요청이면 파일 저장을 수행한다.
	@RequestMapping(value = "/multiUploadOk", method = RequestMethod.POST)
	public String multiUploadOkPost(MultipartHttpServletRequest request, Model model) {
		log.info("{}의 multiUploadOkPost 호출!!!!", this.getClass().getName());
		// 절대 경로 구하기
		String realPath = request.getRealPath(uploadPath);
		// 설명 받기
		String content = request.getParameter("content"); 
		
		// 모든 파일을 한번에 받는다.
		List<MultipartFile> fileList  = request.getFiles("files"); 
		
		StringBuffer sb = new StringBuffer();
		if(fileList!=null && fileList.size()>0) { // 파일들이 있다면
			for(MultipartFile file : fileList) { // 반복
				if(file!=null && file.getSize()>0) { // 파일이 존재 한다면
					try {
						String saveName = FileService.uploadFile(realPath, file.getOriginalFilename(), file.getBytes());
						sb.append("saveName : " +  saveName + "<br/>");
						sb.append("originalName : " + file.getOriginalFilename() + "<br/>");
						sb.append("fileSize : " +  file.getSize() + "<br/>");
						sb.append("contentType : " + file.getContentType() + "<br/>");
						sb.append("folder : " + realPath + "<br/><hr>\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} // end if
			} // end for
			model.addAttribute("files", sb.toString());
			model.addAttribute("content", content);
			return "multiUploadOk";
		}// end if
		return "redirect:/multiUploadForm";	
	}
}
