package kr.green.mvc20;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.mvc20.vo.CommVO;
import kr.green.mvc20.vo.UserVO;

@Controller
public class MappingController {
	// 로그를 출력하기 위한 로거 변수 선언
	static Logger logger = LoggerFactory.getLogger(MappingController.class);
	
	// @RequestMapping : 주소를 만들어 준다.
	// 기본 메서드의 형식 : public String 메스드명(인수들.....)
	
	@RequestMapping(value = "/m1") // "/m1"이라는 주소 생성!!!!
	public String method01() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "method01"; //JSP페이지의 파일 이름만 리턴한다.
	}
	
	@RequestMapping(value = {"/m2","/method/m2","/m2.green"}) // {주소들....} : 한번에 주소 여러개 지정이 가능하다
	public String method02() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "method02"; //JSP페이지의 파일 이름만 리턴한다.
	}
	
	@RequestMapping(value = {"/m3"}) // JSP페이지를 통과하지 않고 출력해보자!!!
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method03() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "한글qwerty1234!@#$"; // 한글 깨짐!!!!!
	}
	
	@RequestMapping(value = "/m4", produces = "text/plain;charset=UTF-8") // content타입을 지정해 준다. "charset" 반드시 소문자!!!!
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method04() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "한글qwerty1234!@#$ 하하하하하하하하하하"; // 한글 나옴!!!!!
	}
	
	// GET/POST다르게 받기
	@RequestMapping(value = "/m5", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET) // GET방식의 요청에만 작동
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method05() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "한글qwerty1234!@#$ 하하하하하하하하하하 GET GET GET"; // 한글 나옴!!!!!
	}
	@RequestMapping(value = "/m5", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST) // POST방식의 요청에만 작동
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method06() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "한글qwerty1234!@#$ 하하하하하하하하하하 POST POST POST"; // 한글 나옴!!!!!
	}
	
	@RequestMapping(value = "/xml1", produces = "text/plain;charset=UTF-8") // content타입을 지정해 준다. Text로 출력
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method07() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "<com><cpu>586</cpu><ram>64기가</ram></com>"; // 한글 나옴!!!!!
	}
	
	@RequestMapping(value = "/xml2", produces = "application/xml;charset=UTF-8") // content타입을 지정해 준다. xml로 출력
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method08() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "<com><cpu>586</cpu><ram>64기가</ram></com>"; // 한글 나옴!!!!!
	}

	@RequestMapping(value = "/json1", produces = "text/plain;charset=UTF-8") // content타입을 지정해 준다. Text로 출력
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method09() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "{\"name\":\"한사람\",\"age\":35}"; // 한글 나옴!!!!!
	}

	@RequestMapping(value = "/json2", produces = "application/json;charset=UTF-8") // content타입을 지정해 준다. Text로 출력
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method10() {
		// 여기서는 서비스를 호출해서 원하는 작업을 수행한다.
		return "{\"name\":\"한사람\",\"age\":35}"; // 한글 나옴!!!!!
	}

	@RequestMapping(value = "/html/{id}", produces = "text/html;charset=UTF-8") // "/html/{id}" : /html/뒤에 나오는 내용을 id를 잡겠다. 
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method11(@PathVariable int id) {
		return "<h1>Path를 이용하여 출력해보자 : " + id + "번 학생정보!!!!</h1>";
	}

	@RequestMapping(value = "/html/{ban}/{no}", produces = "text/html;charset=UTF-8") // "/html/{id}" : /html/뒤에 나오는 내용을 id를 잡겠다. 
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method12(@PathVariable String ban, @PathVariable("no") int number) {
		return "<h1>" + ban + "반의 " + number+ "번 학생정보!!!!</h1>";
	}

	@RequestMapping(value = "/get", produces = "text/html;charset=UTF-8") // /get?ban=fdgfds&no=321432 을 받아 주겠다!!!
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method13(@RequestParam String ban, @RequestParam("no") int number) {
		return "<h1>" + ban + "반의 " + number+ "번 학생정보!!!!</h1>";
	}
	
	@RequestMapping(value = "/get2", produces = "text/html;charset=UTF-8") // /get?ban=fdgfds&no=321432 을 받아 주겠다!!!
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method14(@RequestParam(required = false) String ban, @RequestParam(required = false) Integer no) {
		if(no==null) no=1; // (required = false) : 넘어오는 값이 필수가 아니다!!!!
		if(ban==null) ban="1";
		return "<h1>" + ban + "반의 " + no + "번 학생정보!!!!</h1>";
	}
	
	@RequestMapping(value = "/get3", produces = "text/html;charset=UTF-8") // /get?ban=fdgfds&no=321432 을 받아 주겠다!!!
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method15(HttpServletRequest request) {
		String ban = request.getParameter("ban");
		String no = request.getParameter("no");
		return "<h1>" + ban + "반의 " + no + "번 학생정보!!!!</h1>";
	}
	
	@RequestMapping(value = "/session") // request, session이 필요하면 그냥 인수로 써주면 된다.
	public String method16(HttpServletRequest request, HttpSession session) {
		String ban = request.getParameter("ban");
		String no = request.getParameter("no");
		session.setAttribute("ban", ban);
		session.setAttribute("no", no);
		return "session";
	}
	
	@RequestMapping(value = "/model") //model을 인수로 써주면 된다.
	public String method17(HttpServletRequest request, Model model) {
		String ban = request.getParameter("ban");
		String no = request.getParameter("no");
		model.addAttribute("ban", ban);
		model.addAttribute("no", no);
		return "model";
	}
	
	@RequestMapping(value = "/model2") // 리턴이 String이 아닌  ModelAndView인 경우
	public ModelAndView method18(HttpServletRequest request) {
		String ban = request.getParameter("ban");
		String no = request.getParameter("no");
		ModelAndView mv = new ModelAndView("model"); // 뷰페이지 이름을 넣어서 객체 생성
		mv.addObject("ban", ban); // 값 넣고
		mv.addObject("no", no);
		return mv; // 리턴
	}
	
	@RequestMapping(value = "/board", produces = "text/html;charset=UTF-8") // 기본값에 필수 아님을 지정 가능하다. 짜쯩난다!!!!!
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method19(
			@RequestParam(value = "p", defaultValue = "1", required = false) int p,
			@RequestParam(value = "s", defaultValue = "10", required = false) int s,
			@RequestParam(value = "b", defaultValue = "10", required = false) int b,
			@RequestParam(value = "idx", defaultValue = "-1", required = false) int idx
			) {
		return "<h1>" + p + ",  " + s + ", " + b + ", " + idx + "</h1>";
	}
	
	@RequestMapping(value = "/board2", produces = "text/html;charset=UTF-8") // VO로 받아보자
	@ResponseBody // JSP페이지를 통과하지 않고 출력해라!!!
	public String method20(@ModelAttribute CommVO commVO) {
		return "<h1>" + commVO.getCurrentPage() + ",  " + commVO.getPageSize() + ", " + commVO.getBlockSize() + ", " + commVO.getIdx() + "</h1>";
	}
	
	
	@RequestMapping(value = "/userForm") 
	public String method21() { // 양식을 출력한다.
		return "userForm";
	}
	
	@RequestMapping(value = "/userInsertOk", method = RequestMethod.GET) 
	public String userInsertOkGet() { // GET방식의 처리
		return "redirect:/userForm"; // 무작정 이동!!!
	}
	
	@RequestMapping(value = "/userInsertOk", method = RequestMethod.POST) 
	public String userInsertOkPost(@ModelAttribute CommVO commVO, 
			                       @ModelAttribute UserVO vo, Model model) { // POST 방식의 처리.
		model.addAttribute("vo", vo);
		model.addAttribute("cvo", commVO);
		return "insertOK";
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/userForm2") 
	public String method22() { // 양식을 출력한다.
		return "userForm2";
	}
	
	// JSP로 보기
	@RequestMapping(value = "/user1") 
	public String getUser(@ModelAttribute CommVO commVO, @ModelAttribute UserVO vo, Model model) {
		model.addAttribute("vo", vo);
		model.addAttribute("cvo", commVO);
		return "userInfo";
	}
	
	// XML 또는 JSON으로 보겠다!!! ---- root-context.xml에 메세지 컨버터가 등록되어 있어야 한다.
	@RequestMapping(value = "/user2") 
	@ResponseBody
	public UserVO getUser2(@ModelAttribute UserVO vo, Model model) { 
		return vo;
	}
	
	
}
