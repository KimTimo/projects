package kr.green.core.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Ray {
	@Autowired
	@Qualifier("티코")
	private Car car;
	
	public void showCar() {
		car.showCarName();
	}

}
