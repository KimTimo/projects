package kr.green.core2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling // 스케쥴 활성화
public class AppConfig {
	
	@Bean
	public MyBean bean() {
		return new MyBean();
	}

}
