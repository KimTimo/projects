package kr.green.core.app;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain2 {
	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("main_app.xml");
		//context.getEnvironment().setActiveProfiles("Development");
		//context.refresh();

		context.getEnvironment().setActiveProfiles("Production");
		context.refresh();

		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		System.out.println(dataSource);
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		context.close();
		
	}
}
