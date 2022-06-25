package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.ListObject;
import kr.green.core.vo.MapObject;

public class AppMain8 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app6.xml");
		
		MapObject mapObject = context.getBean("mapObject1", MapObject.class);
		System.out.println(mapObject);
		
		mapObject = context.getBean("mapObject2", MapObject.class);
		System.out.println(mapObject);
		
		mapObject = context.getBean("mapObject3", MapObject.class);
		System.out.println(mapObject);
		
		context.close();
	}
}
