package kr.green.core.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Bond {
	@Autowired
	// @Qualifier("mustang")
	@Qualifier("ferari") // 동일한 타입이 다수일 경우 이름을 직접 지정해서 주입한다.
	private Car car;
	
	public void showCar() {
		car.showCarName();
	}
}
