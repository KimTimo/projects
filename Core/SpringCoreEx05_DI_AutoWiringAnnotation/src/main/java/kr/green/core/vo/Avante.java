package kr.green.core.vo;

import org.springframework.stereotype.Component;

@Component
public class Avante implements Car{
	@Override
	public void showCarName() {
		System.out.println("아반떼");
		
	}

}
