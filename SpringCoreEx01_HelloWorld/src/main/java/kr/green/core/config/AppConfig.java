package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import kr.green.core.vo.HelloWorld;
import kr.green.core.vo.HelloWorldImpl;

@Configuration // 설정 클래스이다.
public class AppConfig {
	
	// @Bean("helloWorld") // 빈을 스프링 프레임워크에 등록한다.(필수사항)
	@Bean(name="helloWorld") // 빈을 스프링 프레임워크에 등록한다.(필수사항)
	@Description("HelloWorldImpl 객체를 등록합니다.") // 설명(선택사항)
	public HelloWorld helloWorld() {
		return new HelloWorldImpl();
	}
}
