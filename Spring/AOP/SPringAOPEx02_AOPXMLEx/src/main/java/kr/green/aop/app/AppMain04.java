package kr.green.aop.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.aop.service.EmployeeService;
import kr.green.aop.vo.EmployeeVO;


public class AppMain04 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("bean4.xml");
		
		EmployeeService service = context.getBean(EmployeeService.class);
		
		System.out.println("-------------------------------------------------------------");
		service.selectById(1);
		System.out.println("-------------------------------------------------------------");
		service.insertEmployee(new EmployeeVO()); 
		System.out.println("-------------------------------------------------------------");
		
		service.deleteEmployee(new EmployeeVO()); 
		System.out.println("-------------------------------------------------------------");

		try {
			service.deleteEmployee(101); // 여기에서만 작동
		} catch (Exception e) {
			;
		} 
		System.out.println("-------------------------------------------------------------");
		
		service.updateEmployee(new EmployeeVO());
		System.out.println("-------------------------------------------------------------");
		service.selectAllList(); 
		System.out.println("-------------------------------------------------------------");
		context.close();
	}
}
