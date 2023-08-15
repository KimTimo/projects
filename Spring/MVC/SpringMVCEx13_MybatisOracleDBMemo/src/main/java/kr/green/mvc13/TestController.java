package kr.green.mvc13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.green.mvc13.service.TestService;
import kr.green.mvc13.vo.TestVO;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/test")
	public String test(Model model, 
			@RequestParam(required = false) Integer num1,
			@RequestParam(required = false) Integer num2) {
		num1 = (num1==null) ?  22: num1;
		num2 = (num2==null) ?  33: num2;

		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("today", testService.selectToday());
		model.addAttribute("sum", testService.selectSum(num1, num2));
		model.addAttribute("mul", testService.selectMul(num1, num2));

		TestVO testVO = new TestVO();
		testVO.setNum1(num1);
		testVO.setNum2(num2);
		model.addAttribute("vo", testService.selectVO(testVO));
		
		return "test";
	}
}
