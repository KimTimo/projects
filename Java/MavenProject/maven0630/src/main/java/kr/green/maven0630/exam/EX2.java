package kr.green.maven0630.exam;

/*
Cardinal to Ordinal 기수를 서수로 바꾸기 : 기수(Cardinal)를 입력하면 영어 서수(Ordinal)로 출력하는 함수를 작성합니다.
1, 21, 31, 41, ... → 1st, 21st, 31st, 41st, ...
2, 22, 32, 42, ... → 2nd, 22nd, 32nd, 42nd, ...
3, 23, 33, 43, ... → 3rd, 23rd, 33rd, 43rd, ...
11, 12, 13, 111, 112, 113, 211, 212, 213, ...  → 11th, 12th, 13th, 111th, 112th, 113th, 211th, 212th, 213th, ...
4, 5, 6, 11, 12, 13, 101, 111, 112, ... → 4th, 5th, 6th, 11th, 12th, 13th, 101th, 111th, 112th, ...
 */
public class EX2 {
	
	public static void main(String[] args) {
		System.out.println(conversion(1) + " " + conversion(21) + " " + conversion(31) + " " + conversion(41));
		System.out.println(conversion(2) + " " + conversion(22) + " " + conversion(32) + " " + conversion(42));
		System.out.println(conversion(3) + " " + conversion(23) + " " + conversion(33) + " " + conversion(43));
		System.out.println(conversion(11) + " " + conversion(12) + " " + conversion(13) + " " + conversion(111) + " " + conversion(112)+ " " + conversion(113));
		System.out.println(conversion(4) + " " + conversion(5) + " " + conversion(6) + " " + conversion(11) + " " + conversion(12)+ " " + conversion(12));
	}

	public static String conversion(int n) {
		String result = "";
		if (n % 10 == 1 && n % 100 != 11)
			result = n + "st";
		else if (n % 10 == 2 && n % 100 != 12)
			result = n + "nd";
		else if (n % 10 == 3 && n % 100 != 13)
			result = n + "rd";
		else
			result = n + "th";
		return result;
	}
}
