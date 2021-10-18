package kr.green.regexp1;

import java.util.regex.Pattern;
/*
로또번호 패턴 만들기
1~45번까지
*/
public class RegExpEx33_Lotto {
	public static void main(String[] args) {

		String lottoPattern1 = "^[1-9]{1}$"; // 1~91자리
		String lottoPattern2 = "^[1-3]{1}[0-9]{1}$"; // 10~39
		String lottoPattern3 = "^4{1}[0-5]{1}$"; // 40~45
		String lottoPattern = lottoPattern1 + "|" + lottoPattern2 + "|" + lottoPattern3;
		System.out.println("로또패턴 : " + lottoPattern);
		System.out.println(Pattern.matches(lottoPattern, "0"));
		System.out.println(Pattern.matches(lottoPattern, "1"));
		System.out.println(Pattern.matches(lottoPattern, "45"));
		System.out.println(Pattern.matches(lottoPattern, "46"));
	}
}
