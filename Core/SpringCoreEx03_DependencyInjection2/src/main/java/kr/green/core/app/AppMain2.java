package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.config.AppConfig1;
import kr.green.core.vo.Employee;

public class AppMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);
		
		Employee employee = context.getBean("employee1", Employee.class); // 기본 생성자를 통한 주입
		System.out.println(employee);
		
		employee = context.getBean("employee2", Employee.class); // 정수 1개인 인수의 생성자
		System.out.println(employee);
		
		employee = context.getBean("employee3", Employee.class); // 문자열 1개인 인수의 생성자
		System.out.println(employee);
		
		employee = context.getBean("employee4", Employee.class); // 정수 1개 문자열 1개인 인수의 생성자
		System.out.println(employee);
		
		employee = context.getBean("employee5", Employee.class); // 문자열 1개 정수 1개인 인수의 생성자
		System.out.println(employee);
		
		employee = context.getBean("employee6", Employee.class); // Setter를 통한 주입
		System.out.println(employee);
		
		employee = context.getBean("employee7", Employee.class); // Setter를 통한 주입
		System.out.println(employee);
				
	    context.close();
	}

}
