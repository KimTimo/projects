package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Address;
import kr.green.core.vo.Person;

public class AppMain3 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app2.xml");
		
		Address address = context.getBean("address1", Address.class);
		System.out.println(address);
		
		address = context.getBean("address2", Address.class);
		System.out.println(address); // 이상한 놈(?)
		
		address = context.getBean("address3", Address.class);
		System.out.println(address);
		
		Person person = context.getBean("person1", Person.class);
		System.out.println(person);
		
		person = context.getBean("person2", Person.class);
		System.out.println(person);
		
		person = context.getBean("person3", Person.class);
		System.out.println(person);
		
		person = context.getBean("person4", Person.class);
		System.out.println(person);
		
		person = context.getBean("person5", Person.class);
		System.out.println(person);
		
		context.close();
	}
}
