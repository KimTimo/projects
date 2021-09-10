package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.config.AppConfig;
import kr.green.core.controller.EmpController;
import kr.green.core.vo.Employee;

public class AppMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		EmpController controller = context.getBean("empController", EmpController.class);
		controller.insert(new Employee(1, "한사람", null));
		context.close();
		
		context = new ClassPathXmlApplicationContext("app.xml");
		controller = context.getBean("empController", EmpController.class);
		controller.insert(new Employee(2, "두사람", null));
		context.close();
		
	}
}
