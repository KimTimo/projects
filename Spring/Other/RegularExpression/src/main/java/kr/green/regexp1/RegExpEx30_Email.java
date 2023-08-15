package kr.green.regexp1;

import java.util.regex.Pattern;
/*
정규표현식으로 이메일 주소 패턴 만들기
xxxxxx@xxxx.xxx
xxxxxx@xxxx.xxx.xx
일반적으로 이메일 주소 형태는 위와 같이 @ 를 기준으로 ID 부와 HOST 부로 나뉩니다. 
이 ID 와 HOST 부에 적용할 이메일 주소 패턴의 형태를 정하겠습니다. 

ID 부 설정
1. 영문 대소문자 허용
2. 숫자 허용
3. . _ % + -  등 5가지 특문 허용

HOST 부 설정
1. 영문 대소문자 허용
2. 숫자 허용
3. . - 등 2가지 특문 허용
4. 위 값이 최소 1개 이상 표기된 후  .  추가
5. 마침표 뒤에는 영문자 대소문자 만 허용
6. 마침표 뒤의 문자 셋은 최소 2 ~ 최대 6 자리 까지만 허용
*/
public class RegExpEx30_Email {
	public static void main(String[] args) {
		// 영문 대소문자 허용 : a-zA-Z
		// 숫자 허용 : 0-9
		// . _ % + -  등 5가지 특문 허용 : ._%+-
		// 1글자 이상 : +
		String idPattern = "^[a-zA-Z0-9._%+-]+";
		
		// 영문 대소문자 허용 : a-zA-Z
		// 숫자 허용 : 0-9
		// .  -  등 2가지 특문 허용 : .-
		// 1글자 이상 : +
		// .이나타나고 : \\.
		// 영문자 2~6자 : [a-zA-Z]{2,6}
		String hostPattern = "[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
		String emailPattern = idPattern + "@" + hostPattern;
		System.out.println("Email정규식 : " + emailPattern);
		
		String[] emails = "test5004@kimc.com,test-5004@kimc.com,test%5004@kimc.com,test+5004@kimc.kr,test5004@kimc.co.kr".split(",");
		for(String email : emails) {
			System.out.println(email + " : " + Pattern.matches(emailPattern, email));
		}
		System.out.println();
		// 문제
		System.out.println("test+5004@kimc..kr : " + Pattern.matches(emailPattern, "test+5004@kimc..kr"));
		System.out.println();
		
		// 두번째
		emailPattern = "^[0-9a-zA-Z]([._%+-]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,6}$";
		for(String email : emails) {
			System.out.println(email + " : " + Pattern.matches(emailPattern, email));
		}
		System.out.println();
		System.out.println("test+5004@kimc..kr : " + Pattern.matches(emailPattern, "test+5004@kimc..kr"));
		// 위의 내용도 완벽하지 않습니다. 도메인 형식이 아주 다양하기 때문입니다. 한글도메인도 있습니다.
	}
}
