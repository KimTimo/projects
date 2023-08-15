package kr.green;

class FinalInt{
	// 이런 경우는 변경할 수  없지만 객체마다 다른 값을 갖게하고 싶은 경우에 사용한다.
	// 이때는 반드시 final변수에 값을 줄 수 있는 생성자를 만들어 주어야한다. // 그리고 statsic이 될 수 없다.
	final double PI; // 초기화 되지 않은 final 변수를 가지는 클래스는 어떻게 될가?

	public FinalInt(double pI) {
		super();
		PI = pI;
	}
}

public class Ex02_FinalInit {

	public static void main(String[] args) {
		FinalInt f1 = new FinalInt(3.14);
		FinalInt f2 = new FinalInt(3.1415);
		FinalInt f3 = new FinalInt(3.141592);
		// 객체마다 다른 값
		System.out.println(f1.PI);
		System.out.println(f2.PI);
		System.out.println(f3.PI);
		
		// 상수일까?
		// f3.PI = 3.141;; // 에러다. 변경은 못함.

	}

}
