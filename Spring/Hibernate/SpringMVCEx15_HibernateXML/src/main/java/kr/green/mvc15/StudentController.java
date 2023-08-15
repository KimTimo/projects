package kr.green.mvc15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.green.mvc15.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", studentService.selectList());
		return "list";
	}
}
