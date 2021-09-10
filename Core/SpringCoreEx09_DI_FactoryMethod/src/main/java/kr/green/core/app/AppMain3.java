package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo2.Printable;

public class AppMain3 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("app3.xml");
		
		Printable printableA = context.getBean("a", Printable.class);
		printableA.print();
		
		Printable printableB = context.getBean("b", Printable.class);
		printableB.print();
		
		Printable printableC = context.getBean("c", Printable.class);
		printableC.print();
		
		context.close();
	}
}
