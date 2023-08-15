package kr.green.aop.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.aop.vo.EmployeeManager;
import kr.green.aop.vo.EmployeeVO;

public class AppMain01 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("appConfig.xml");
		
		// 인수로 이름이 아닌 클래스를 넘기면 형변환이 필요없다
		// EmployeeManager manager = (EmployeeManager)context.getBean("employeeManager");
		EmployeeManager manager = context.getBean(EmployeeManager.class);
		
		// 이 메서드 앞뒤로 무언가가 자동으로 실행되었다!!!
		EmployeeVO vo = manager.getEmployeeById(1);
		
		System.out.println("출력 : " + vo);
		
		vo = manager.getEmployeeName("나직원");
		
		System.out.println("출력 : " + vo);
		
		context.close();
	}
}
