package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.SetObject;

public class AppMain6 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app4.xml");
		
		SetObject setObject = context.getBean("setObject1", SetObject.class);
		System.out.println(setObject);
		
		setObject = context.getBean("setObject2", SetObject.class);
		System.out.println(setObject);
		
		setObject = context.getBean("setObject3", SetObject.class);
		System.out.println(setObject);
		
		context.close();
	}
}
