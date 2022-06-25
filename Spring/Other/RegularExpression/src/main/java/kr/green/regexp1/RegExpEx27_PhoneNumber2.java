package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx27_PhoneNumber2 {
	public static void main(String[] args) {
		// 핸드폰 전화번호 정규식
		String patternStr = "^01[016789]-\\d{3,4}-\\d{4}$";

		String[] phoneNumbers = "010-111-2222,110-1234-1234,016-1234-2345,010-12-9870,02-2252-3333".split(",");

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
