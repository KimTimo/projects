package kr.green.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"kr.green.boot"})
public class BootEx01Application {

	public static void main(String[] args) {
		SpringApplication.run(BootEx01Application.class, args);
	}

}
