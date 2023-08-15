/*
A씨는 두 개의 버전을 비교하는 프로그램을 작성해야 한다.
버전은 다음처럼 "." 으로 구분된 문자열이다.
버전 예) 1.0.0, 1.0.23, 1.1
두 개의 버전을 비교하는 프로그램을 작성하시오.

출력 예)
0.0.2 > 0.0.1
1.0.10 > 1.0.3
1.2.0 > 1.1.99
1.1 > 1.0.1
 */
public class Ex09 {

	public static void main(String[] args) {
		compVersion("0.0.2", "0.0.1");
		compVersion("1.0.10", "1.0.3");
		compVersion("1.2.0", "1.1.99");
		compVersion("1.1", "1.0.1");
		// 같은 경우나 뒤에가 큰경우 테스트
		compVersion("1.1", "1.1");
		compVersion("1.0", "1.1");
		
		// 데이터를 정제하지 않으면 오류가 발생할 수 있는 경우
		compVersion("1.1.1", "1.1"); // 이 부분 // 배열의 첨자 범위를 넘었다는 예외
		compVersion("1.1", "1.1.1"); // 이 부분 // 뒤에것이 큰데 == 라고 나온다. 앞 2자리만 비교해서 그렇다.
		compVersion("1.1.1", "1.1.1.0.0.1"); // 이 부분 // 뒤에것이 큰데 == 라고 나온다. 앞 3자리만 비교해서
		

	}

	public static void compVersion(String version1, String version2) {
		//-----------------------------------------------------------------------------
		// 두자리가 넘어오든 세자리가 넘어오든 배열의 크기를 맞춰줘야 한다.
		// 어케함?
		// 1. 먼저 배열로 만들었을때 길이를 구한다.
		int len1 = version1.split("\\.").length;
		int len2 = version2.split("\\.").length;
		// 2. 짧은 길이의 배열인 쪽에 같은 길이의 배열이 되도록 ".0"을 추가해야 한다.
		if(len1<len2) {
			for(int i = 0; i < len2-len1; i++) version1 += ".0";
				
		}
		String ver1[] = version1.split("\\."); // .으로 구분하여 배열로 만든다.
		String ver2[] = version2.split("\\.");
		String result = "==";
		
		for(int i = 0; i < ver1.length; i++) {
			int iver1 = Integer.parseInt(ver1[i]);
			int iver2 = Integer.parseInt(ver2[i]);
			if(iver1>iver2) {
				result = ">";
				break;
			}else if(iver1<iver2) {
				result = "<";
				break;
			}
		}
		System.out.println(version1 + " " + result + " " + version2);
	}
}
