package kr.green.ex0610;

public class CharTypeEx {

	public static void main(String[] args) {

		char ch = 'A';
		//char ch2 = "A"; // 에러 : ""(큰 따옴표)는 String이다.
		//char ch3 = ''; // 어떤 글자라도 1개 저장이 되어야 한다.
		char ch4 = ' '; // 빈칸을 나타내는 문자 저장
		char ch5 = 65; // ASCII코드값 65번에 해당하는 문자가 저장.
		System.out.println("ch = " + ch);
		System.out.println("ch5 = " + ch5);
		ch5 = 97;
		System.out.println("ch5 = " + ch5);
		
		// 대문자 + 32 = 소문자
		// 소문자 - 32 = 대문자
		System.out.println("b - 32 = " + (char)('g'-32));
		System.out.println("b - 32 = " + (char)('F'+32));
		
		// X의 ASCII 코드값은?
		System.out.println("A의 코드값 : " + ('A'+0));
		System.out.println("0의 코드값 : " + ('0'+0));
		System.out.println("ㄱ의 코드값 : " + ('ㄱ'+0));
		System.out.println("ㄱ의 코드값 : " + ('ㄱ'+1));
		System.out.println("ㄱ의 코드값 : " + (char)('ㄱ'+1));
		
		char ch6 = '\n'; // \에 ㅣ어 숫자 혹은 영문자가 나오면 제어문자이다.
		System.out.println("하" + ch6 + "하" + ch6 + ch6 + "호");
		
		for(int i = 0; i <= 65635; i++) {
			System.out.println((char)i);
		}
		
		
	}

}
