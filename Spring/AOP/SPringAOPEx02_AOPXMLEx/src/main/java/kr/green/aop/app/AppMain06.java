package kr.green.aop.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.aop.service.EmployeeService;
import kr.green.aop.vo.EmployeeVO;


public class AppMain06 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("bean6.xml");
		
		EmployeeService service = context.getBean(EmployeeService.class);
		
		System.out.println("-------------------------------------------------------------");
		service.selectById(1); // 여기
		System.out.println("-------------------------------------------------------------");
		service.insertEmployee(new EmployeeVO());  // 여기
		System.out.println("-------------------------------------------------------------");
		service.deleteEmployee(new EmployeeVO()); // 여기
		System.out.println("-------------------------------------------------------------");
		service.updateEmployee(new EmployeeVO());// 여기
		System.out.println("-------------------------------------------------------------");
		service.selectAllList(); // 여기
		System.out.println("-------------------------------------------------------------");
		context.close();
	}
}
