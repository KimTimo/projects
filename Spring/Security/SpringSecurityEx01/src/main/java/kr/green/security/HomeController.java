package kr.green.security;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("user", getPrincipal());
		return "home";
	}
	@RequestMapping(value = "/home")
	public String homepage(Model model) {
		model.addAttribute("msg","여기는 누구나 접근 가능한 페이지입니다.");
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}
	@RequestMapping(value = "/Access_Denied")
	public String Access_Denied(Model model) {
		model.addAttribute("msg","등록되지 않은 사용자이거나 비밀번호가 일치하지 않습니다.");
		return "Access_Denied";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// 시큐리트를 이용하여  인증 정보를 얻어낸다. 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null) { // 인증  정보가 있으면
			new SecurityContextLogoutHandler().logout(request, response, authentication); // 로그아웃을 시킨다.
		}
		return "redirect:/";
	}
	@RequestMapping(value = "/admin")
	public String admin(Model model) {
		model.addAttribute("msg", "관리자 전용 페이지 입니다.");
		model.addAttribute("user", getPrincipal());
		return "admin";
	}
	
	@RequestMapping(value = "/dba")
	public String dba(Model model) {
		model.addAttribute("msg", "DB관리자 전용 페이지 입니다.");
		model.addAttribute("user", getPrincipal());
		return "dba";
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
