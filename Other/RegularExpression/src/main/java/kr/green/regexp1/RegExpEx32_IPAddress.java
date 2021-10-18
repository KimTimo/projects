package kr.green.regexp1;

import java.util.regex.Pattern;
/*
정규표현식으로 IP 주소 패턴 만들기
IP 주소는 다음과 같은 형식을 취하고 있습니다. 
xxx . xxx . xxx . xxx
이는 우리가 일반적으로 많이 사용하고 있는 IP Version 4 (IPv4) 주소 체계입니다. 
각 옥텟의 xxx 값은 0 ~ 255 까지의 숫자가 올 수 있습니다. 
즉, 0.0.0.0 부터 255.255.255.25 까지의 주소가 가능합니다. 
*/
public class RegExpEx32_IPAddress {
	public static void main(String[] args) {
		// 첫번째 자리는 0 또는 1만 허용하고 0 또는 1이 존재 하거나 존재하지 않아도 됩니다.  : [01]? : 
		// 두번째 자리는 숫자를 허용하며 값이 존재하거나 하지 않아도 됩니다. : \\d?
		// 세번째 자리는 숫자를 허용하며 무조건 존재 해야 합니다.  : \\d
		String ipPattern1 = "[01]?\\d?\\d"; // 0 ~ 199
		// 200~ 255처리
		String ipPattern2 = "2[0-4]\\d"; // 200 ~249
		String ipPattern3 = "25[0-5]"; // 250 ~255
		
		// 각각의 표현식을 합쳐 묶어보면 
		String ipPattern4 = "(" + ipPattern1 + "|" + ipPattern2 + "|" + ipPattern3 + ")";
		System.out.println(ipPattern4);

		// 위의 패턴이 .으로 구분하여 4자리 이므로
		String ipPattern = "^" + ipPattern4 + "\\." + ipPattern4 + "\\."+ ipPattern4 + "\\."+ ipPattern4 + "$";
		System.out.println(ipPattern);
		
		String[] ips = "0.0.0.0,255.255.255.255,127.0.0.1,210.0.256.0".split(",");
		for(String ip : ips) {
			System.out.println(ip + " : " + Pattern.matches(ipPattern, ip));
		}
	}
}
