package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx10_Matcher4 {
	public static void main(String[] args) {
		// int java.util.regex.Matcher.groupCount() : 패턴에 있는 그룹()의 개수
		String inputStr = "아 지리산 아~ 금강산 아아~~ 한라산 아아아~~~ 백두산 아아아아~ 뒷동산";
		Pattern pattern1 = Pattern.compile("아*~* ..산");
		Matcher matcher1 = pattern1.matcher(inputStr);
		System.out.println(pattern1 + ".groupCount() : " + matcher1.groupCount() + "개");

		Pattern pattern2 = Pattern.compile("(아*)~* ..산");
		Matcher matcher2 = pattern2.matcher(inputStr);
		System.out.println(pattern2 + ".groupCount() : " + matcher2.groupCount() + "개");
		
		Pattern pattern3 = Pattern.compile("(아*)(~*) (..산)");
		Matcher matcher3 = pattern3.matcher(inputStr);
		System.out.println(pattern3 + ".groupCount() : " + matcher3.groupCount() + "개");
		
		Pattern pattern4 = Pattern.compile("((아*)(~*)( )(..산))");
		Matcher matcher4 = pattern4.matcher(inputStr);
		System.out.println(pattern4 + ".groupCount() : " + matcher4.groupCount() + "개");
	}
}
