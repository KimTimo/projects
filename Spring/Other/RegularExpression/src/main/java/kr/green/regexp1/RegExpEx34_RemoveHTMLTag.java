package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
HTML태그 없애기
*/
public class RegExpEx34_RemoveHTMLTag {
	public static void main(String[] args) {

		String inputStr = "<h1>나는<img ><img src='xxx.png' width='100'/><span><b><q>제목</q></b></span>입니다.</h1>";
		
		try {
			System.out.println(removeTag(inputStr));
			System.out.println(removeTag(inputStr,"q"));
			System.out.println(removeTag(inputStr,"img"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Pattern pattern = Pattern.compile("<(/)?([a-zA-Z0-9]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>");
		Matcher matcher = pattern.matcher(inputStr);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
	public static String removeTag(String html) throws Exception {
		return html.replaceAll("<(/)?([a-zA-Z0-9]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
	public static String removeTag(String html,String tag) throws Exception {
		return html.replaceAll("<(/)?("+tag+")*(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
}
