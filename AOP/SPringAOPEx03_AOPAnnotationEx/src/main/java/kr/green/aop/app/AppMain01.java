package kr.green.aop.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.aop.service.EmployeeService;
import kr.green.aop.vo.EmployeeVO;


public class AppMain01 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("bean1.xml");
		
		EmployeeService service = context.getBean(EmployeeService.class);
		
		System.out.println("-------------------------------------------------------------");
		service.selectById(1);  // befor/after/after/around/around
		System.out.println("-------------------------------------------------------------");
		service.insertEmployee(new EmployeeVO()); // after/around/around
		System.out.println("-------------------------------------------------------------");
		service.deleteEmployee(new EmployeeVO()); // after/around/around
		System.out.println("-------------------------------------------------------------");
		
		context.close();
	}
}
