package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx09_Matcher3 {
	public static void main(String[] args) {
		String inputStr = "아 지리산 아~ 금강산 아아~~ 한라산 아아아~~~ 백두산 아아아아~ 뒷동산";
		Pattern pattern = Pattern.compile("..산");
		Matcher matcher = pattern.matcher(inputStr);
		System.out.println("\"" + inputStr + "\" 중에서 \"..산\"이란 문자가 있는 위치");
		int count = 0;
		while (matcher.find()) {
			System.out.print("찾은 위치값 :\t" + matcher.start() + "~" + (matcher.end()-1));			
			System.out.println(" ==> " + inputStr.substring(matcher.start(),matcher.end()));		
			count++;
		}
		System.out.println("총 " + count + "개 찾음\n");
	}
}
