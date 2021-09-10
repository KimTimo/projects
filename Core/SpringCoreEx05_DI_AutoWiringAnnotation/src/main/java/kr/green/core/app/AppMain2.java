package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.AppConfig2;
import kr.green.core.vo.Employee;

public class AppMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig2.class);
		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee);
		context.close();
	}
}
