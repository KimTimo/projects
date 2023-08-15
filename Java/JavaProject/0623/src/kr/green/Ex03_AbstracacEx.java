package kr.green;

// 추상 클래스 : 1개 이상의 추상 메소드를 가지는 클래스
//               미완성 설계도. 객체를 생성할 수 없다. 일반 변수와 일반 메소드를 가질 수 있다.
//               자식클래스는 반드시 오버라이딩 해야하는 규칙을 가지게 된다.
abstract class AbstractClass {
	abstract void move(); // 추상 메소드 : 내용이 없는 메소드. 자식클래스는 반드시 오버라이딩 해야 하는 규칙을 가지가 된다.
}

class AbstractChild extends AbstractClass{

	@Override
	void move() {
		System.out.println("차를 옮깁니다.");
	}
	
}

public class Ex03_AbstracacEx {
	public static void main(String[] args) {
		AbstractClass a = new AbstractClass() {

			@Override
			void move() {
				System.out.println("원을 옮깁니다.");
			}
		};
		a.move();


	}

}
