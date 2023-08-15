package kr.green.core2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("Production") // 프로필의 이름을 지정한다. 
@PropertySource("classpath:jdbc.properties")
public class ProductionDatabaseConfig implements DatabaseConfig {

	@Autowired
	Environment environment;
	
	@Override
	// @Bean("dataSource")
	public DataSource dataSource() {
		System.out.println("운영용 데이터베이스 : Oracle 설정");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("o.driver"));
		dataSource.setUrl(environment.getProperty("o.url"));
		dataSource.setUsername(environment.getProperty("o.username"));
		dataSource.setPassword(environment.getProperty("o.password"));
		return dataSource;
	}

}
