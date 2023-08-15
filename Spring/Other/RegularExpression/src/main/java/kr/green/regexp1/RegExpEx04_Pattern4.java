package kr.green.regexp1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RegExpEx04_Pattern4 {
	public static void main(String[] args) {
		// \s :	공백 문자
		String inputStr = "자바 정규표현식 :\tPattern클래스\nsplit메서드 연습";
		Pattern pattern1 = Pattern.compile("\\s");

		// String[] java.util.regex.Pattern.split(CharSequence input)
		String[] strArray = pattern1.split(inputStr);
		System.out.println(Arrays.toString(strArray));
		
		Pattern pattern2 = Pattern.compile(":");
		inputStr = "자바:정규표현식:Pattern클래스:::split메서드 연습";
		// String[] java.util.regex.Pattern.split(CharSequence input, int limit)
		String[] strArray2 = pattern2.split(inputStr, 4);
		System.out.println(Arrays.toString(strArray2));
		
		// 양수일 때에는 limit 번째부터 split을 하지 않으며, 음수일 때에는 공백 또한 데이터에 포함합니다.
		String[] strArray3 = pattern2.split(inputStr, -1);
		System.out.println(Arrays.toString(strArray3));
		System.out.println();
	}
}
