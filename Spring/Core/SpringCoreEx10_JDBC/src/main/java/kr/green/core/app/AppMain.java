package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.service.SimpleService;

public class AppMain {
	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("maria_app.xml");

		SimpleService simpleService = context.getBean("mariaService", SimpleService.class);
		System.out.println("오늘의 DB날짜 : " + simpleService.getNow());
		int num1 = 34, num2 = 29;
		System.out.println(num1 + " * " + num2 + " = " + simpleService.getCalc(num1, num2));
		
		context.close();
		
	}
}
