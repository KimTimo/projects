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
		service.selectById(1); // before/after 적용
		System.out.println("-------------------------------------------------------------");
		service.insertEmployee(new EmployeeVO()); // before/after 적용, transaction적용
		System.out.println("-------------------------------------------------------------");
		
		service.deleteEmployee(new EmployeeVO()); // before/after 적용, transaction적용
		System.out.println("-------------------------------------------------------------");
		service.updateEmployee(new EmployeeVO());
		System.out.println("-------------------------------------------------------------");
		context.close();
		service.selectAllList();
		System.out.println("-------------------------------------------------------------");
		context.close();
	}
}
