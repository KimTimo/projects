package kr.green.interceptor;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		return "home";
	}
	@RequestMapping(value="/login")
	public String login(Model model, HttpServletRequest request) {
		model.addAttribute("msg", "아이디와 비번을 입력하고 로그인하세요... 같으면 로그인성공!!!");
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("userId");
		return "home";
	}

	@RequestMapping(value="/loginOk", method = RequestMethod.GET)
	public String loginOkGET(Model model, HttpServletRequest request) {
		model.addAttribute("msg", "잘못된 접근입니다.");
		return "login";
	}
	
	@RequestMapping(value="/loginOk", method = RequestMethod.POST)
	public String loginOkPOST(Model model, HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		if(userId.equals(password)){
			request.getSession().setAttribute("userId", userId);
			return "home";
		}else{
			model.addAttribute("msg", "아이디나 비번을 확인하세요");
			return "login";
		}
	}

	@RequestMapping(value="/list")
	public String list(Model model, HttpServletRequest request) {
		model.addAttribute("message", "누구나 사용가능합니다.");
		return "list";
	}

	@RequestMapping(value="/admin/insert")
	public String insert(Model model, HttpServletRequest request) {
		model.addAttribute("message", "회원이므로 사용가능합니다.");
		return "insert";
	}	

}
