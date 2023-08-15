package kr.green;

class FinalParent{
	public final void show() {
		System.out.println("나는 오버라이딩이 금지되는 메소드 입니다.");
	}
}

class FinalChild extends FinalParent{
//	public final void show() {
//		System.out.println("나는 오버라이딩이 금지되는 메소드 입니다.");
//	}
}

final class Some{ // 클래스 앞에 final이 붙으면 상송을 제한한다.
	
}

//class SomeChild extends Some{ // 에러. 상속금지
//	
//}

public class Ex01_FinalEx {
	static final int MAX = 1024; // 변수 앞에 final이 붙으면 변경 불가 일반적으로 static과 같이 사용한다.
	final static double PI = 3.141592; // 일반 변수와 구분하기 위해서 대문자로 단어사이는 _로 연결하여 선언

	public static void main(String[] args) {
		System.out.println("최대값 : " + Ex01_FinalEx.MAX);
		System.out.println("원주율 : " + Ex01_FinalEx.PI);
		System.out.println("원주율 : " + Math.PI);
		
		
	}
}
