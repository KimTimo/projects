package kr.green.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.calendar.service.TestService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {
	@Autowired
	TestService testService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("DB테스트 시작!!!!!");
		String today = testService.selectToday();
		int sum = testService.selectSum(11,45);
		int mul = testService.selectMul(1, 2, 3);
		
		model.addAttribute("today", today );
		model.addAttribute("sum", sum );
		model.addAttribute("mul", mul );
		
		return "test";
	}
	
}
