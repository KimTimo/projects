package kr.green.maven0625.sb;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		String[] data = "0123456789 01234 01234567890 6789012345 012322456789".split(" ");
		for(String t : data) {
			System.out.println(checkDuplicateNumbers(t));
		}
	}
	
	public static boolean checkDuplicateNumbers(String t) {
		String[] strAr = t.split(""); // String 배열로 만들고	
		Arrays.sort(strAr); // 정렬
		String str = String.join("", strAr); // 문자열로 결합
		return str.equals("0123456789"); // "0123456789"과 같으면 1번만 사용

	}

}
