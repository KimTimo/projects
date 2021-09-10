package kr.green.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.green.core.service.EmpService;
import kr.green.core.vo.Employee;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	public void insert(Employee employee) {
		empService.registerEmployee(employee);
		System.out.println("EmpController에서 empService의 메서드를 호출한다.");
	}

}
