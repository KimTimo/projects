package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx08_Matcher2 {
	public static void main(String[] args) {
		String inputStr = "아 지리산 아~ 금강산 아아~~ 한라산 아아아~~~ 백두산 아아아아~ 뒷동산";
		// Pattern java.util.regex.Pattern.compile(String regex)
		Pattern pattern = Pattern.compile("아*~* ..산");
		
		// Matcher java.util.regex.Pattern.matcher(CharSequence input)
		Matcher matcher = pattern.matcher(inputStr);
		System.out.print("\"" + inputStr + "\"");
		System.out.println(" 중에서 \"" + pattern + "\"으로 찾는중!!!");
		int count = 0;
		// boolean java.util.regex.Matcher.find()
		while(matcher.find()){
			count++;
			System.out.println(count + ". " + matcher.group());
		};
		System.out.println("전체 " + count + "개 찾음");
		System.out.println();
		
		matcher = pattern.matcher(inputStr);
		System.out.print("\"" + inputStr + "\"");
		System.out.println(" 중에서 \"" + pattern + "\"으로 20번째 부터 찾는중!!!");
		count = 0;
		if(matcher.find(20)) {
			do{
				count++;
				System.out.println(count + ". " + matcher.group());
			}while(matcher.find());
			System.out.println("전체 " + count + "개 찾음");
		}else {
			System.out.println("못찾음");
		}
		System.out.println();
		
		matcher = pattern.matcher(inputStr);
		System.out.print("\"" + inputStr + "\"");
		System.out.println(" 중에서 \"" + pattern + "\"으로 40번째 부터 찾는중!!!");
		count = 0;
		if(matcher.find(40)) {
			do{
				count++;
				System.out.println(count + ". " + matcher.group());
			}while(matcher.find());
			System.out.println("전체 " + count + "개 찾음");
		}else {
			System.out.println("못찾음");
		}
	}
}
