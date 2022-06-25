package kr.green.regexp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx18_Example5 {
	public static void main(String[] args) {
		String inputStr = "대한민국123456qwertyQWERTY";
		// 1글자씩 잘라 배열/리스트로 만들기
		Pattern pattern = Pattern.compile("");
		System.out.println(Arrays.toString(pattern.split(inputStr)));
		System.out.println(Arrays.toString(inputStr.split("")));
		System.out.println(Arrays.asList(inputStr.split("")));
		System.out.println();
		
		System.out.println(splitLength(inputStr, 1));
		System.out.println(splitLength(inputStr, 3));
		System.out.println(splitLength(inputStr, 5));
		System.out.println(splitLength(null, 7));
	}
	// 문자열을 길이만큼씩 잘라 List<String>로 리턴하는 메서드
	// parameter : 문자열,길이
	public static List<String> splitLength(String inputStr, int length){
		List<String> list = null;
		if(inputStr!=null) {
			list = new ArrayList<String>();
			int end = 0;
			Pattern pattern = Pattern.compile(".{"+length+"}");
			Matcher matcher = pattern.matcher(inputStr);
			while (matcher.find()) {
	            list.add(matcher.group());
	            end = matcher.end();
			}
			if(end<inputStr.length()) list.add(inputStr.substring(end));
		}
		return list;
	}
}
