package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Singleton;

public class AppMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app2.xml");
		
		Singleton singleton1 = context.getBean("singleton1", Singleton.class);
		singleton1.show();

		Singleton singleton2 = context.getBean("singleton2", Singleton.class);
		singleton2.show();
		
		context.close();
	}
}
