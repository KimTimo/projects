package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.AppConfig5;
import kr.green.core.vo.Bond;

public class AppMain5 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig5.class);
		context.getBean("bond", Bond.class).showCar();
		context.close();
	}
}
