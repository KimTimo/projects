package kr.green.core.vo;

import org.springframework.stereotype.Component;

@Component
public class Ferari implements Car{
	@Override
	public void showCarName() {
		System.out.println("Ferari");
	}
}
