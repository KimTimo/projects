package kr.green.core.vo;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello(String name) {
		System.out.println(name + "씨 스프링의 세계에 오신것을 환영합니다.");		
	}

}
