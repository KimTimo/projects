package kr.green.exam;

// 10진수를 n진법으로 바꾸는 프로그램 작성
public class Ex01 {

	public static void main(String[] args) {

		int num = 73;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));
		System.out.println("---------------------------");
		System.out.println();
		System.out.println(conversion(num, 2));
		System.out.println(conversion(num, 8));
		System.out.println(conversion(num, 16));
		System.out.println(conversion(num, 10));
		System.out.println(conversion(num, 5));
	}

	// num을 base진법으로 변환해주는 메소드
	public static String conversion(int num, int base) {
		String result = "";
		while (num > 0) {
			// 나머지는 계속 앞에 붙이고
			// 10보다 적으면 숫자로 10 이상이면 ABCDEF....
			// (char)(num%base-10 + 'A') 는 아래처럼 계산된다.
			// 10-10+'A' = 'A', 11-10+'A' = 'B'
			// + ""는 왜 했을까? char가 + 을 ㅎ서 코드값이 숫자로 다시 변경 그래서 ""를 더해 String 으로 만듬     
			result = (num % base < 10 ? num % base : (char) (num % base - 10 + 'A') + "") + result;
			// 몫을 가지고 계속 계산
			num /= base;
		}
		return result;
	}
}
