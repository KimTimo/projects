package kr.green.core.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("applicationUser") // 객체를 빈으로 등록한다.
@Data
public class ApplicationUser {
	private String name = "무명";
}
