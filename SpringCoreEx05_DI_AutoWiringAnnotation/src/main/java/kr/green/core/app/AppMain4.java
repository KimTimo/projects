package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.AppConfig4;
import kr.green.core.vo.Driver;

public class AppMain4 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig4.class);
		System.out.println(context.getBean("driver", Driver.class));
		context.close();
	}
}
