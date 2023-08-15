package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
비밀번호 : 숫자,영소문자, 영대문자, 특수문자 포함
*/
public class RegExpEx31_Password {
	public static void main(String[] args) {
		System.out.println(passwordCheck1("123") + " : " + passwordCheck2("123"));
		System.out.println(passwordCheck1("!@#") + " : " + passwordCheck2("!@#"));
		System.out.println(passwordCheck1("abcABC") + " : " + passwordCheck2("abcABC"));
		System.out.println(passwordCheck1("1A!") + " : " + passwordCheck2("1A!"));
		System.out.println(passwordCheck1("aA!") + " : " + passwordCheck2("aA!"));
		System.out.println(passwordCheck1("1aA") + " : " + passwordCheck2("1aA"));
		System.out.println(passwordCheck1("1a!") + " : " + passwordCheck2("1a!"));
		System.out.println(passwordCheck1("1aA!") + " : " + passwordCheck2("1aA!"));
		System.out.println(passwordCheck1("12abAB!@") + " : " + passwordCheck2("12abAB!@"));
	}

	// 정규표현식을 사용하지 않는 경우
	public static boolean passwordCheck1(String password) {
		String specialChar = "~`!@#$%^&*()_-+=\\|![]{};:'\"?/>.<,";
		String numStr = "0123456789";
		String alphabetUpperStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetLowerStr = "abcdefghijklmnopqrstuvwxyz";
		boolean isSpecialChar = false, isNum = false, isAlphabetUpperStr = false, isAlphabetLowerStr = false;
		for (String s : password.split("")) {
			if (specialChar.contains(s)) isSpecialChar = true;
			if (numStr.contains(s)) isNum = true;
			if (alphabetUpperStr.contains(s)) isAlphabetUpperStr = true;
			if (alphabetLowerStr.contains(s)) isAlphabetLowerStr = true;
		}
		// System.out.println("\n" + password);
		// System.out.println(isSpecialChar ? "특수문자 포함" : "특수문자 미포함");
		// System.out.println(isNum ? "숫자 포함" : "숫자 미포함");
		// System.out.println(isAlphabetLowerStr ? "영소문자 포함" : "영소문자 미포함");
		// System.out.println(isAlphabetUpperStr ? "영대문자 포함" : "영대문자 미포함");
		return isSpecialChar && isNum && isAlphabetLowerStr && isAlphabetUpperStr;
	}

	// 정규표현식을 사용는 경우
	public static boolean passwordCheck2(String password) {
		// 최소 3자리에 대문자 1자리 소문자 1자리 숫자 1자리 특수문자 1자리 포함
		// (?=.*[a-z]) : 소문자 최소 1개
		// (?=.*[A-Z]) : 대문자 최소 1개
		// (?=.*\\d) : 숫자 최소 1개
		// (?=.*[$@$!%*?&]) : 특수문자 최소 1개
		// .{4,} : 선행문자 최소 4글자 이상
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&]).{4,}");
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
