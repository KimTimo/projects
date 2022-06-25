package kr.green.mvc07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.green.mvc07.service.TestService;
import kr.green.mvc07.vo.TestVO;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/test")
	public String test(Model model) {
		String today = testService.today();
		int num1=56, num2=34;
		int sum = testService.sum(num1,num2);
		int mul = testService.mul(num1,num2);
		model.addAttribute("today", today);
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("sum", sum);
		model.addAttribute("mul", mul);
		return "test";
	}
	@RequestMapping(value = "/testVO")
	public String testVO(Model model, 
			@RequestParam(required = false) Integer num1, 
			@RequestParam(required = false) Integer num2) {
		TestVO testVO = new TestVO();
		if(num1==null) {
			testVO.setNum1(23);
		}else {
			testVO.setNum1(num1);
		}
		if(num2==null)
			testVO.setNum2(45);
		else
			testVO.setNum2(num2);
			
		testVO = testService.getTestVO(testVO);
		model.addAttribute("testVO", testVO);
		return "testVO";
	}
}
