package kr.green.security;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	/*
	@RequestMapping(value = "/Access_Denied")
	public String Access_Denied(Model model) {
		model.addAttribute("msg","등록되지 않은 사용자이거나 비밀번호가 일치하지 않습니다.");
		return "Access_Denied";
	}
	*/
	@RequestMapping(value = "/login")
	public String login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model) {
		
		if (error!=null) {
			model.addAttribute("error","아이디나 비번 없다");
		}
		if (logout!=null) {
			model.addAttribute("msg","로그아웃 성공!!!");
		}
		return "login";
	}
	
	// 접근 권한이 없는 페이지에 접근하면 보여줄 페이지
	@RequestMapping(value = "/403")
	public String page403(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			System.out.println(userDetails);
			model.addAttribute("username", userDetails.getUsername());
		}
		return "403";
	}
	
	/*
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// 시큐리트를 이용하여  인증 정보를 얻어낸다. 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null) { // 인증  정보가 있으면
			new SecurityContextLogoutHandler().logout(request, response, authentication); // 로그아웃을 시킨다.
		}
		return "redirect:/";
	}
	*/
	
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
	
	// 암호화 하기 테스트
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// 평문 비번을 암호화 하기 
	@RequestMapping(value = "/getPwd")
	public String getPassword(
			@RequestParam(value = "pwd", required = false) String password,
			Model model) {
		if(password==null) password = "admin";
		String newPassword = bCryptPasswordEncoder.encode(password);
		model.addAttribute("password", password);
		model.addAttribute("newPassword", newPassword);
		return "bcrypt";
	}
	
	// 암호화된 비번을 비교하기
	@RequestMapping(value = "/checkPwd")
	public String checkPwd(
			@RequestParam(value = "pwd", required = false) String password,
			Model model) {
		if(password==null) password = "admin";
		
		String dbPassword = bCryptPasswordEncoder.encode("admin"); // 이렇게 DB에 저장되었다고 가정
		boolean isCheck1 = bCryptPasswordEncoder.matches(password, dbPassword); // 일치여부 판단하기(반드시 이놈으로 비교해야 함)
		model.addAttribute("isCheck1", isCheck1);

		String newPassword = bCryptPasswordEncoder.encode(password); 
		boolean isCheck2 = newPassword.equals(dbPassword); // 일치여부 판단하기 (않된다)
		model.addAttribute("isCheck2", isCheck2);
		
		model.addAttribute("dbPassword", dbPassword);
		model.addAttribute("newPassword", newPassword);
		
		
		return "bcrypt2";
	}
	
	
	
	
}
