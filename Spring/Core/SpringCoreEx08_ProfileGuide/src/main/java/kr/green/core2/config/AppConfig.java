package kr.green.core2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"kr.green.core2"})
public class AppConfig {

	@Autowired
	public DataSource dataSource;
}
