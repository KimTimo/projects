package kr.green.aop.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.aop.aop.Operation;

public class AppMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =   new ClassPathXmlApplicationContext("applicationContext.xml");

		Operation e = (Operation) context.getBean("opBean");  
		System.out.println("\ncalling msg..."); 
        e.msg();  
        
        System.out.println("\ncalling m...");  
        e.m(); 
        
        System.out.println("\ncalling k...");  
        e.k();  

        System.out.println("\ncalling display...");  
        e.display();  
        
        System.out.println("\ncalling validate...");  
        try {
			e.validate(19);
		} catch (Exception e1) {
			System.out.println("예외 : " + e1.getMessage());
		}  
        
        System.out.println("\ncalling validate...");  
        try {
        	e.validate(23);
        } catch (Exception e1) {
        	System.out.println("예외 : " + e1.getMessage());
        }  
        
        context.close();
	}
}
