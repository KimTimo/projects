package kr.green.maven0702.lambda;

public class Ex04_Lambda {
	public static void main(String[] args) {
		// 함수형 인터페이스 : 단 하나의 추상 메소드만을 가지는 인터페이스. 이 인터페이스를 이용하여 람다(익명 객체)를 만들어 사용합니다.
		//                     이미 자바에는 많은 종류의 함수형 만들어 놓았으므로 찾아서 쓰면 됩니다.
		//                     Runnable : 인수도 없고 리턴값도 없는 익명함수를 만들때 사용
		
		Runnable helloEng = ()->System.out.println("Hello");
		Runnable helloKor = ()->System.out.println("해위~");
		Runnable errorMessage = ()->System.out.println("에러가 발생했슴다.");
		
		helloEng.run();
		helloKor.run();
		errorMessage.run();
	}
}
