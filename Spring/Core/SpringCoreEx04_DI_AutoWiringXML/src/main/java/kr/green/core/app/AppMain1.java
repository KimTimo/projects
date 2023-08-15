package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Application;

public class AppMain1 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app1.xml");
		
		Application application = context.getBean("application1", Application.class);
		System.out.println(application);
		
		application = context.getBean("application1", Application.class);
		System.out.println(application);
		
		application = context.getBean("application2", Application.class);
		System.out.println(application);
		
		application = context.getBean("application3", Application.class);
		System.out.println(application);
		
		application = context.getBean("application4", Application.class);
		System.out.println(application);
		
		application = context.getBean("application5", Application.class);
		System.out.println(application);
		
		application = context.getBean("application6", Application.class);
		System.out.println(application);
		
		context.close();
	}
}
