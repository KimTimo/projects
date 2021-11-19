package kr.green.searches.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.searches.service.MemberService;
import kr.green.searches.service.MemberServiceImpl;
import kr.green.searches.vo.MemberRoleVO;
import kr.green.searches.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}

	// 아이디 중복확인
	@RequestMapping(value = "/idCheck", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String idCheck(@RequestParam String userid) {
		log.info("{}의 idCheck 호출 : {}", this.getClass().getName(), userid);
		int count = memberService.idCheck(userid);
		log.info("{}의 idCheck 리턴 : {}", this.getClass().getName(), count);
		return count + "";
	}

	// 회원가입 완료!!!
	@RequestMapping(value = "/joinOk", method = RequestMethod.GET)
	public String joinOkGet(Model model) {
		log.info("{}의 joinOkGet 호출 : {}", this.getClass().getName(), null);
		return "redirect:/";
	}

	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOkPost(@ModelAttribute MemberVO memberVO, Model model) {
		log.info("{}의 joinOkPost 호출 : {}", this.getClass().getName(), memberVO);
		// 서비스를 호출하여 DB에 저장한다.
		memberService.insert(memberVO);
		return "redirect:/";
	}

	// 이메일 인증처리
	@RequestMapping(value = "/authOk")
	public String authOk(@ModelAttribute MemberVO memberVO, Model model) {
		log.info("{}의 authOk 호출 : {}", this.getClass().getName(), memberVO);
		// 서비스를 호출하여 이메일 인증처리를 한다.
		MemberVO memberVO2 = memberService.emailConfirm(memberVO);
		model.addAttribute("vo", memberVO2);
		return "authOk";
	}

	@RequestMapping(value = "/login")
	public String login(@RequestParam Map<String, String> param, // 모든 넘어오는정보를 맵으로 받기
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "아이디나 비번이 존재하지 않습니다.");
		}
		if (logout != null) {
			model.addAttribute("msg", "로그아웃 성공!!!");
		}
		log.info("{}의 login 호출 : {}", this.getClass().getName(), param);
		return "login";
	}

	// 접근 권한이 없는 페이지에 접근하면 보여줄 페이지
	@RequestMapping(value = "/403")
	public String page403(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			System.out.println(userDetails);
			model.addAttribute("username", userDetails.getUsername());
		}
		return "403";
	}

	// 인증정보를 시큐리티에서 얻어내는 메서드
	private String getPrincipal() {
		String username = "";
		Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (object instanceof UserDetails) {
			username = ((UserDetails) object).getUsername();
		} else {
			username = object.toString();
		}
		return username;
	}

	@RequestMapping(value = "/admin/list")
	public String adminList(Model model) {
		model.addAttribute("msg", "여기는 관리자 전용페이지입니다.");
		return "admin/list";
	}

	@RequestMapping(value = "/mem/list")
	public ModelAndView memList() {
		ModelAndView mv = new ModelAndView("mem/list");
		mv.addObject("msg", "여기는 회원 전용페이지입니다.");
		return mv;
	}

	// 아이디 찾기 실행
	@RequestMapping(value = "/findUserId", method = RequestMethod.GET)
	public String findIdAction(MemberVO memberVO, Model model) {
		MemberVO userId = memberService.useridSearch(memberVO);

		if (userId == null) {
			model.addAttribute("check", 1);
		} else {
			model.addAttribute("check", 0);
			model.addAttribute("id", userId.getUserid());
		}

		return "/findUserId";
	}

	// 비밀번호 찾기 실행
	@RequestMapping(value = "findPassword", method = RequestMethod.GET)
	public String findPasswordAction(MemberVO memberVO, Model model) {
		MemberVO password = memberService.passwordSearch(memberVO);

		if (password == null) {
			model.addAttribute("check", 1);
		} else {
			model.addAttribute("check", 0);
			model.addAttribute("updateid", password.getPassword());
		}

		return "findPassword";
	}

	// 비밀번호 바꾸기 실행
	@RequestMapping(value = "changePassword", method = RequestMethod.GET)
	public String updatePasswordAction(@RequestParam(value = "updateid", defaultValue = "", required = false) String id,
			MemberVO memberVO) {
		memberVO.setPassword(id);
		;
		System.out.println(memberVO);
		memberService.changePassword(memberVO);
		return "changePassword";
	}

	// 비밀번호 바꾸기할 경우 성공 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String checkPasswordForModify(MemberVO memberVO, Model model) {
		MemberVO chagepw = (MemberVO) memberService.changePassword(memberVO);

		if (chagepw == null) {
			return "/login";
		} else {
			return "/403";
		}
	}

	// 회원탈퇴
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(MemberVO memberVO, Model model) {
		MemberVO delete = memberService.delete(memberVO);

		if (delete == null) {
			model.addAttribute("check", 1);
		} else {
			model.addAttribute("check", 0);
			model.addAttribute("id", delete.getIdx());
		}

		return "/delete";
	}

}
