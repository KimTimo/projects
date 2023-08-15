package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.AppConfig1;
import kr.green.core.vo.Application;

public class AppMain1 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig1.class);
		System.out.println(context.getBean("application", Application.class));
		context.close();
	}
}
