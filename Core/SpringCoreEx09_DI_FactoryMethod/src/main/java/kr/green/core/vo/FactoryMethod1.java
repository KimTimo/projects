package kr.green.core.vo;

public class FactoryMethod1 {
	public void show() {
		System.out.println("FactoryMethod1");
	}
	public FactoryMethod1() {
		System.out.println("생성자를 이용한 객체생성");
	}
	// 팩토리 메서드
	public static FactoryMethod1 getFactoryMethod1() {
		System.out.println("메서드를 이용한 객체생성");
		return new FactoryMethod1();
	}
}
