package kr.green.core;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
	public void printMessage() {
		System.out.println("스케쥴러에 의해서 호출되었습니다.----- 1");
	}
	public void printMessage2() {
		System.out.println("나는 언제 호출될까요? ----- 2");
	}
	public void printMessage3() {
		System.out.println("나는 어떻게 호출될까요? ----- 3");
	}

}
