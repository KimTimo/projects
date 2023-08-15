package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.FactoryMethod1;

public class AppMain1 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app1.xml");
		
		FactoryMethod1 method1 = context.getBean("method1", FactoryMethod1.class);
		method1.show();
		FactoryMethod1 method2 = context.getBean("method2", FactoryMethod1.class);
		method2.show();
		
		context.close();
	}
}
