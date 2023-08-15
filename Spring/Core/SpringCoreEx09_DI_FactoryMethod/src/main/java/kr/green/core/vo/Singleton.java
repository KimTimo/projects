package kr.green.core.vo;

public class Singleton {
	private static Singleton instance = new Singleton();
	private Singleton() { System.out.println("private 생성자 호출");}
	public static Singleton getInstance() {
		System.out.println("static 메서드 호출!!");
		return instance;
	}
	//--------------------------------------------------
	public void show() {
		System.out.println("싱글톤 패턴의 클래스~~~~");
	}
}
