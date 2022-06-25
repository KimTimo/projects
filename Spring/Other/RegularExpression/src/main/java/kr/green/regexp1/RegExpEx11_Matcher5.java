package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx11_Matcher5 {
	public static void main(String[] args) {
		String inputStr = "아 지리산 아~ 금강산 아아~~ 한라산 아아아~~~ 백두산 아아아아~ 뒷동산";
		Pattern pattern = Pattern.compile("(아*)(~*)( )(..산)");
		Matcher matcher = pattern.matcher(inputStr);
		System.out.println("그룹의 개수 : " + matcher.groupCount() + "개");
		while(matcher.find()) {
			// String java.util.regex.Matcher.group()
			System.out.println("group() :\t" + matcher.group());		
			for(int i=0;i<=matcher.groupCount();i++) {
				// String java.util.regex.Matcher.group(int group)
				System.out.println(String.format("group(%d) :\t%s",i,matcher.group(i)));		
			}
			System.out.println();
		}
	}
}
