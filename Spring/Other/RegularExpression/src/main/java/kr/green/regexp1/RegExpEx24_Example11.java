package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx24_Example11 {
	public static void main(String[] args) {
		// 그룹 개념 이용하기
		String[] inputArray = "설악산,지리산,금산,설악봉,지리봉,금봉,설악대,지리대,금대".split(",");
		System.out.print("산 : ");
		for(String str : inputArray) {
			if(Pattern.matches(".*산", str)) System.out.print(str + " ");
		}
		System.out.println();
		
		System.out.print("지리 : ");
		for(String str : inputArray) {
			// if(Pattern.matches("지리산|지리봉|지리대", str)) System.out.print(str + " ");
			if(Pattern.matches("지리(산|봉|대)", str)) System.out.print(str + " ");
		}
		System.out.println();
		
		System.out.print("지리/설악 : ");
		for(String str : inputArray) {
			if(Pattern.matches("(지리|설악)(산|봉|대)", str)) System.out.print(str + " ");
		}
		System.out.println();
	}
}
