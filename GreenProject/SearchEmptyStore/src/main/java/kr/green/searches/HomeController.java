package kr.green.searches;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.searches.service.MailService;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("user", getPrincipal() );
		
		//mailService.sendMail("eogsu8548@naver.com", "eogsu8548@naver.com", "제목", "내용");
		
		return "home";
	}
	// 인증정보를 시큐리티에서 얻어내는 메서드
	private String getPrincipal() {
		String username = "";
		Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(object instanceof UserDetails) {
			username = ((UserDetails) object).getUsername();
		}else {
			username = object.toString();
		}
		return username;
	}
}

