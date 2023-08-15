package kr.green.mvc19;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.green.mvc19.service.BoxOfficeService;
import kr.green.mvc19.vo.BoxOfficeResult;
import kr.green.mvc19.vo.BoxOfficeResult2;
import kr.green.mvc19.vo.MemberList;
import kr.green.mvc19.vo.PersonVO;
import kr.green.mvc19.vo.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String getPizza(Model model) {
		model.addAttribute("pizza", new Pizza("불고기"));
		return "pizza";
	}
	
	@RequestMapping(value = "/Pizza", method = RequestMethod.GET)
	@ResponseBody // 그냥 출력해라 --- jsp를 통과하지 않고
	public Pizza getPizza() {
		return new Pizza("고구마");
	}

	@RequestMapping(value = "/person")
	@ResponseBody // 그냥 출력해라 --- jsp를 통과하지 않고
	public PersonVO getPerson() {
		return new PersonVO("한사람", 22, false, new Date(99,1,5));
	}
	
	@RequestMapping(value = "/persons")
	@ResponseBody // 그냥 출력해라 --- jsp를 통과하지 않고
	public MemberList getPersons() {
		List<PersonVO> list = new ArrayList<>();
		list.add(new PersonVO("한사람", 22, true, new Date(78,2,12)));
		list.add(new PersonVO("두사람", 22, true, new Date(78,2,12)));
		list.add(new PersonVO("세사람", 22, true, new Date(78,2,12)));
		list.add(new PersonVO("네사람", 22, true, new Date(78,2,12)));
		list.add(new PersonVO("오사람", 22, true, new Date(78,2,12)));
		list.add(new PersonVO("육사람", 22, true, new Date(78,2,12)));
		return new MemberList("떠든학생", list); 
	}
	
	/*
	오늘의 과제
	-----------
	영화 진흥 위원회에서 제공하는 "일별 박스오피스 API 서비스"데이터를 읽어서 xml, json으로 출력하는 프로그램을 작성하시요!!!
	예)
	http://localhost:8080/mvc19/boxOffice.xml?targetDt=20210418 [엔터]  ==> xml로
	http://localhost:8080/mvc19/boxOffice.json?targetDt=20210418 [엔터]  ==>json로

	*/	
	@RequestMapping(value = "/boxOffice") // 일별
	public @ResponseBody BoxOfficeResult data4(HttpServletRequest request) {
		String targetDt = request.getParameter("targetDt");
		return BoxOfficeService.readBoxOffice(targetDt);
	}
	
	@RequestMapping(value = "/boxOffice2") // 주간
	public @ResponseBody BoxOfficeResult2 data5(HttpServletRequest request) {
		String targetDt = request.getParameter("targetDt");
		return BoxOfficeService.readBoxOffice2(targetDt);
	}
}
