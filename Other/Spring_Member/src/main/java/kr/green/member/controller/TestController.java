package kr.green.member.controller;

import java.util.HashMap;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.green.member.service.MailService;
import kr.green.member.service.TestService;
import lombok.experimental.Helper;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {
	@Autowired
	TestService testService;

	@Autowired
	MailService mailService;

	// 다운로드 주소
	@RequestMapping(value = "/download")
	public ModelAndView download(@RequestParam HashMap<Object, Object> params, ModelAndView mv) {
		String ofileName = (String) params.get("of"); // 원본이름
		String sfileName = (String) params.get("sf"); // 저장이름
		mv.setViewName("downloadView");
		mv.addObject("ofileName", ofileName);
		mv.addObject("sfileName", sfileName);
		return mv;
	}

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("DB테스트 시작!!!!!");
		String today = testService.selectToday();
		int sum = testService.selectSum(11,45);
		int mul = testService.selectMul(1, 2, 3);
		
		model.addAttribute("today", today );
		model.addAttribute("sum", sum );
		model.addAttribute("mul", mul );
		
		log.info("메일 보내기 테스트 시작!!!!!");
		// mailService.sendMail("itsungnam202106@gmail.com", "itsungnam202106@gmail.com", "나제목2", "나 내용 갈까?2");

		return "test";
	}
	
}
