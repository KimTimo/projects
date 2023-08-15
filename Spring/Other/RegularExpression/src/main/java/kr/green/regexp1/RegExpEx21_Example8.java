package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx21_Example8 {
	public static void main(String[] args) {
		// ^ : 문자열의 시작을 나타냄
		// $ : 문자열의 끝을 나타냄
		String[] domains = "http://www.aaa.com,https://bbb.com,https://bbb.net,www.bbb.org".split(",");
		// System.out.println("원본 : " + Arrays.toString(domains));
		System.out.println("도메인 이름이 http로 시작되는가?");
		for(String domain : domains) {
			System.out.println(domain + " : " + Pattern.matches("^http(.*)", domain));
		}
		System.out.println();
		System.out.println("도메인 이름이 .com으로 끝나는가?");
		for(String domain : domains) {
			System.out.println(domain + " : " + Pattern.matches(".*\\.com$", domain));
			//System.out.println(domain + " : " + Pattern.matches(".*\\.com", domain));
		}
		System.out.println();

		System.out.println("도메인 이름이 http로 시작해서 .com으로 끝나는가?");
		for(String domain : domains) {
			System.out.println(domain + " : " + Pattern.matches("^(http)(.*)(\\.com)$", domain));
		}
		System.out.println();
		
		// 그런데 만약, 문자열에 포함되어있는 .(온점)을 검색하고 싶을 때에는 어떻게 해야할까요?
		// 다음은 This로 시작하고 "."으로 끝나는 패턴을 찾습니다. 만약 "."으로 끝나지 않으면 false를 리턴합니다.
		System.out.println("This is the right decision.".matches("This.*\\."));
		System.out.println("This is me".matches("This.*\\."));
		System.out.println("This is my mistake.".matches("This.*\\."));
		System.out.println();
	}
}
