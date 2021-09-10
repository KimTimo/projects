package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Application;
import kr.green.core.vo.Driver;
import kr.green.core.vo.Employee;
import kr.green.core.vo.Perfomer;

public class AppMain4 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app4.xml");
		System.out.println(context.getBean("driver", Driver.class));
		context.close();
	}
}
