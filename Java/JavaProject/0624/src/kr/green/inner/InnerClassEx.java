package kr.green.inner;

class OuterClass{
	int iv=1; // 인스턴스 변수
	static int sv = 10; // 정적(클래스) 변수
	class InstanceInner{ // 인스턴스 내부 클래스
		int inner_iv=100;
		void view() {
			System.out.println("iv = " + iv);
			System.out.println("sv = " + sv);
			System.out.println("inner_iv = " + inner_iv);
		}
	}
	static class StaticInner{ // 정적 내부 클래스
		int static_iv=100;
		static int static_sv=200;
		void iview() {
			// System.out.println("iv = " + iv); // 정적 내부 클래스에서 인스턴스 변수 사용 불가
			System.out.println("sv = " + sv);
			System.out.println("static_iv = " + static_iv);
			System.out.println("static_sv = " + static_sv);
		}
		static void sview() {
			// System.out.println("iv = " + iv); // 정적 내부 클래스의 정적 메서드에서 인스턴스 변수 사용 불가
			System.out.println("sv = " + sv);
			// System.out.println("static_iv = " + static_iv); //  정적 메서드에서 인스턴스 변수 사용 불가
			System.out.println("static_sv = " + static_sv);
		}
	}
}
public class InnerClassEx {
	public static void main(String[] args) {
		OuterClass.StaticInner.sview(); // 정적 내부클래스의 정적 메서드 호출 
		
		// 정적 내부 클리스의 객체 선언
		OuterClass.StaticInner si = new OuterClass.StaticInner();
		si.iview(); //객체를 생성했으니까 인스턴스 메서드 호출 가능
		
		// 인스턴스 내부 클래스의 객체 선언
		OuterClass outer = new OuterClass();
		OuterClass.InstanceInner oi = outer.new InstanceInner(); // new의 위치 주의
		oi.view();
		
		
	}
}
