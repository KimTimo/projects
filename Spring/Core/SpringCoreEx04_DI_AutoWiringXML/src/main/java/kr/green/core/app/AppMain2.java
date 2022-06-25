package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Application;
import kr.green.core.vo.Employee;

public class AppMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app2.xml");
		
		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee);
		
		context.close();
	}
}
