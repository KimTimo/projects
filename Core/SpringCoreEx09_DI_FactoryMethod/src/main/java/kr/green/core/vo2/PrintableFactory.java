package kr.green.core.vo2;

public class PrintableFactory {
	// 객체를 생성해주는 클래스를 팩토리 패턴
	public static Printable getPrintableA() {
		return new HelloA();
	}
	
	public static Printable getPrintableB() {
		return new HelloB();
	}

	public static Printable getPrintableC() {
		return new HelloC();
	}
}
