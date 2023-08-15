package kr.green.mvc17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.green.mvc17.service.MailService;
import kr.green.mvc17.vo.MailVO;

@Controller
public class MailController {

	@Autowired
	private MailService mailService;
	
	
	@RequestMapping(value = "/mailForm")
	public String mailForm() {
		return "mailForm";
	}
	
	@RequestMapping(value = "/sendMail")
	public String sendMail(@ModelAttribute MailVO mailVO ) {
		mailService.sendEmail(mailVO);
		return "sendMail";
	}
}
