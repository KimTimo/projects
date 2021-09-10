package kr.green.maven0625.sb;

import static org.junit.Assert.assertEquals;

/*
DashInsert 함수는 숫자로 구성된 문자열을 입력받은 뒤, 문자열 내에서 홀수가 연속되면 두 수 사이에 - 를 추가하고,
짝수가 연속되면 * 를 추가하는 기능을 갖고 있다. (예, 454 => 454, 4546793 => 454*67-9-3) DashInsert 함수를 완성하자.
입력 - 화면에서 숫자로 된 문자열을 입력받는다.
"4546793"

출력 - *, -가 적절히 추가된 문자열을 화면에 출력한다.
"454*67-9-3"
 */

public class Ex03 {

	public static void main(String[] args) {
		System.out.println(dashInsert1("454"));
		System.out.println(dashInsert2("454"));
		System.out.println(dashInsert3("454"));
		System.out.println("---------------------------------------");

		System.out.println(dashInsert1("4546793"));
		System.out.println(dashInsert2("4546793"));
		System.out.println(dashInsert3("4546793"));
		System.out.println("---------------------------------------");
	}

	public void testDashInsert() {
		assertEquals(dashInsert1("454"), "454");
		assertEquals(dashInsert1("4546793"), "454*67-9-3");
	}

	public static String dashInsert1(String str) {
		String result = str.charAt(0) + "";
		char old = str.charAt(0); // 이전 글자 기억
		for (int i = 1; i < str.length(); i++) {
			if ((old - '0') % 2 == 0 && (str.charAt(i) - '0') % 2 == 0) // 짝수가 연속되면 * 추가
				result += '*';
			if ((old - '0') % 2 == 0 && (str.charAt(i) - '0') % 2 != 0) // 홀수가 연속되면 - 추가
				result += '-';
			result += str.charAt(i); // 둘다 아니면 그냥 추가
			old = str.charAt(i); // 이전 글자를 현재 글자로 변경
		}
		return result;
	}

	public static String dashInsert2(String str) {
		StringBuffer sb = new StringBuffer(str);
		StringBuffer result = new StringBuffer(str);
		char old = str.charAt(0); // 이전 글자 기억
		for (int i = 1; i < str.length(); i++) {
			if ((old - '0') % 2 == 0 && (str.charAt(i) - '0') % 2 == 0) // 짝수가 연속되면 * 추가
				result.append("*");
			if ((old - '0') % 2 == 0 && (str.charAt(i) - '0') % 2 != 0) // 홀수가 연속되면 - 추가
				result.append("-");
			result.append(sb.charAt(i));
			old = str.charAt(i); // 이전 글자를 현재 글자로 변경
		}

		return result.toString();
	}

	public static String dashInsert3(String str) {

		return "";
	}

}
