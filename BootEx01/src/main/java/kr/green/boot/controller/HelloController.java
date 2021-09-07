package kr.green.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// @RestController // 뷰를 통하지 않고 출력
@Controller
public class HelloController {
	
	@RequestMapping("/") // URL주소 생성
	public String home(Model model) {
		// 뷰페이지에서 사용할 처리 결과를 담아놓는다. 뷰페이지에서 EL로 출력가능하다.
		model.addAttribute("title","스프링 부트");
		model.addAttribute("message","반갑다 스프링 부트!!!!");
		return "hello"; // 뷰페이지 이름을 리턴
	}
}
