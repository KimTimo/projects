package kr.green.aop.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.aop.service.EmployeeService;
import kr.green.aop.vo.EmployeeVO;


public class AppMain02 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("bean2.xml");
		
		EmployeeService service = context.getBean(EmployeeService.class);
		
		System.out.println("-------------------------------------------------------------");
		service.selectById(1); // before
		System.out.println("-------------------------------------------------------------");
		service.insertEmployee(new EmployeeVO()); // before 적용 
		System.out.println("-------------------------------------------------------------");
		service.deleteEmployee(new EmployeeVO()); // before 적용
		System.out.println("-------------------------------------------------------------");
		service.updateEmployee(new EmployeeVO());// before 적용 
		System.out.println("-------------------------------------------------------------");
		service.selectAllList();// before 적용 
		System.out.println("-------------------------------------------------------------");
		context.close();
	}
}
