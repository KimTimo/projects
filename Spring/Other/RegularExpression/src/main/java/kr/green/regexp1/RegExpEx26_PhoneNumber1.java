package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx26_PhoneNumber1 {
	public static void main(String[] args) {
		// 일반 전화번호 정규식
		String patternStr = "^0\\d{2,3}-\\d{3,4}-\\d{4}$";

		String[] phoneNumbers = "02-111-2222,031-1234-1234,064-123-4567,1234-2345,02-12-9870,02-222-33333".split(",");

		for (String tel : phoneNumbers) {
			System.out.print(tel + "은 ");
			if (Pattern.matches(patternStr, tel)) {
				System.out.println("맞는형식");
			} else {
				System.out.println("잘못된 형식");
			}
		}
	}
}
