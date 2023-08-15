package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.AppConfig3;
import kr.green.core.vo.Performer;

public class AppMain3 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig3.class);
		System.out.println(context.getBean("performer", Performer.class));
		context.close();
	}
}
