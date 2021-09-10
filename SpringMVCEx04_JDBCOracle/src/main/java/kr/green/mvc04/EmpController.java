package kr.green.mvc04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.green.mvc04.service.EmployeeService;
import kr.green.mvc04.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmpController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// 리스트
	@RequestMapping(value = "/list") // 메서드와 주소를 연결하고 뷰페이지를 리턴하도록 만든다.
	public String getAll(Model model) {
		log.debug(this.getClass().getName() + "의 getAll 호출");
		List<EmployeeVO> list = employeeService.getAll();
		log.debug(this.getClass().getName() + "의 getAll 결과 : " + list);
		model.addAttribute("list", list);
		return "list";
	}
	// 저장
	@RequestMapping(value = "/insertOk") // 메서드와 주소를 연결하고 뷰페이지를 리턴하도록 만든다.
	public String insert(@ModelAttribute EmployeeVO employeeVO) { // @ModelAttribute : VO로 데이터 받기
		log.debug(this.getClass().getName() + "의 insert 호출 : " + employeeVO);
		employeeService.save(employeeVO);		
		return "redirect:/list";
	}
	
	
	// 수정
	@RequestMapping(value = "/updateOk") // 메서드와 주소를 연결하고 뷰페이지를 리턴하도록 만든다.
	public String update(@ModelAttribute EmployeeVO employeeVO) { // @ModelAttribute : VO로 데이터 받기
		log.debug(this.getClass().getName() + "의 update 호출 : " + employeeVO);
		employeeService.update(employeeVO);
		return "redirect:/list";
	}
	
	// 삭제
	@RequestMapping(value = "/deleteOk") // 메서드와 주소를 연결하고 뷰페이지를 리턴하도록 만든다.
	public String delete(@ModelAttribute EmployeeVO employeeVO) { // @ModelAttribute : VO로 데이터 받기
		log.debug(this.getClass().getName() + "의 delete 호출 : " + employeeVO);
		employeeService.deleteById(employeeVO.getId());
		return "redirect:/list";
	}
	
}
