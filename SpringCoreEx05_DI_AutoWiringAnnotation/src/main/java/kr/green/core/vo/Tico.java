package kr.green.core.vo;

import org.springframework.stereotype.Component;

@Component
public class Tico implements Car{
	@Override
	public void showCarName() {
		System.out.println("티코");
	}

}
