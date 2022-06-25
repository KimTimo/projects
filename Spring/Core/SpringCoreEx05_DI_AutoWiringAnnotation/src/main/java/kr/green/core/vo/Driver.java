package kr.green.core.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
	@Autowired(required = false) // 존재하지 않는 객체를 자동으로 주입하면 에러다.
								 // 존재하지 않으면 주입하지 마라고 지정이 가능하다. : required = false
	private License license;
}
