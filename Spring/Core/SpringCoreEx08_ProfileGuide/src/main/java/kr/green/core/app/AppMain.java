package kr.green.core.app;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("Development");
		context.scan("kr.green.core");
		context.refresh();

		//context.getEnvironment().setActiveProfiles("Production");
		//context.scan("kr.green.core");
		//context.refresh();

		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		System.out.println(dataSource);
		
		context.close();
		
	}
}
