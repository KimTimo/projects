package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.ListObject;

public class AppMain7 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app5.xml");
		
		ListObject listObject = context.getBean("listObject1", ListObject.class);
		System.out.println(listObject);
		
		listObject = context.getBean("listObject2", ListObject.class);
		System.out.println(listObject);
		
		listObject = context.getBean("listObject3", ListObject.class);
		System.out.println(listObject);
		
		context.close();
	}
}
