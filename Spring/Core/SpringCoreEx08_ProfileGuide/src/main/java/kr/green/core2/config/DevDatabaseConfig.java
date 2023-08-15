package kr.green.core2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("Development") // 프로필의 이름을 지정한다. 
@PropertySource("classpath:jdbc.properties")
public class DevDatabaseConfig implements DatabaseConfig {

	@Autowired
	Environment environment;
	
	@Override
	// @Bean
	public DataSource dataSource() {
		System.out.println("개발용 데이터베이스 : Mariadb 설정");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("m.driver"));
		dataSource.setUrl(environment.getProperty("m.url"));
		dataSource.setUsername(environment.getProperty("m.username"));
		dataSource.setPassword(environment.getProperty("m.password"));
		return dataSource;
	}
}
