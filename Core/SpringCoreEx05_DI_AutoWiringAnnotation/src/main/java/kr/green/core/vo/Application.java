package kr.green.core.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component() // 객체를 빈으로 등록한다.
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Application {
	@Autowired // 자동으로 주입해라
	private ApplicationUser applicationUser;
}
