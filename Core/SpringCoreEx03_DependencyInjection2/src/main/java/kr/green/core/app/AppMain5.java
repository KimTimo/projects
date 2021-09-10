package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.ArrayObject;

public class AppMain5 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app3.xml");
		
		ArrayObject arrayObject = context.getBean("arrayObject1", ArrayObject.class);
		System.out.println(arrayObject);
		
		arrayObject = context.getBean("arrayObject2", ArrayObject.class);
		System.out.println(arrayObject);
		context.close();
	}
}
