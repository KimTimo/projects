package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.config.AppConfig;
import kr.green.core.service.FileService;

public class AppMain {

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		FileService fileservice = (FileService) context.getBean("fileService", FileService.class);
		fileservice.readValue();
		context.close();
		
		System.out.println("---------------------------------------------------------");
		
		context = new ClassPathXmlApplicationContext("app.xml");
		fileservice = context.getBean("fileService", FileService.class);
		fileservice.readValue();

		
		System.out.println("---------------------------------------------------------");
		System.out.println(fileservice);
		context.close();
	}
}
