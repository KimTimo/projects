package chapter2;

public class CharacterEx {

	public static void main(String[] args) {

		char ch = 'A';
		
		System.out.println(ch);
		System.out.println((int)ch); // A가 가지고있는 값 65가 출력
		
		ch = 66; // ch의 값을 66으로 초기화
		
		System.out.println(ch); // 66이 가지고 있는 값 B가 출력
		System.out.println((int)ch); // char형 변수를 int형 변수로 캐스팅 시켜 66이 출력
		
		int ch2 = 67;
		System.out.println(ch2);
		System.out.println((char)ch2); // int형 변수를 char형 변수로 캐스팅 시켜 C로 출력됨
		
		
	}

}
