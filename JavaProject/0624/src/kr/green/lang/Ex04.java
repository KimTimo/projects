package kr.green.lang;
// 문자열.substring(시작위치)
// 문자열.substring(시작위치, 끝위치)

public class Ex04 {

	public static void main(String[] args) {
		String str = "헬조선 크크루삥뽕";
		System.out.println(str.substring(4));
		System.out.println(str.substring(2, 7));
		
		String name = "[김벌처]";
		System.out.println(name);
		// 괄호를 제거하라!
		name = name.substring(1, name.length()-1);
		System.out.println(name);
		
		String emails[] = {"itsungnam201606@gamil.com", "itsungnam201606@naver.com", "itsungnam201606@daum.net"};
		for(String email : emails) {
			
			System.out.println(email);
			// 이메일에서 아이디만 뽑는 방법
			System.out.println(email);
			System.out.println(email.substring(0, email.indexOf('@')));
			
			// System.out.println(email.replace("@gmail.com", ""));
			System.out.println();
			System.out.println(email.split("@")[0]);
			System.out.println("------------------------------------");
		}
	}

}
