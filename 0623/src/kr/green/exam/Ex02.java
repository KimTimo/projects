package kr.green.exam;
/*
 Palindrome
 */
public class Ex02 {

	public static void main(String[] args) {

		System.out.println(isPalindrome(101) ? "대칭수" : "비대칭수");
		System.out.println(isPalindrome(1001) ? "대칭수" : "비대칭수");
		System.out.println(isPalindrome(9009) ? "대칭수" : "비대칭수");
		System.out.println(isPalindrome(9008) ? "대칭수" : "비대칭수");
		System.out.println(isPalindrome(9019) ? "대칭수" : "비대칭수");
		int max = 0; // 제일 큰값을 넣을거다.... 예상되는 값들 중에서 제일 적은값 보다 적게 초기화 해야 한다. 
		for(int i = 100; i < 1000; i++) {
			for(int j = 100; j < 1000; j++) {
				if(isPalindrome(i*j))
				System.out.println((i*j) + "는 " + (isPalindrome(i*j) ? "대칭수" : "비대칭수"));
				if(max<i*j) max = i*j; // 구한 값이 max보다 크다면 max값을 변경
			}
		}
		System.out.println("제일 큰 대칭수 : " + max);
		
	}
	
	// 넘어온 숫자가 대칭수 인지 판단하는 메소드 : 배열 뒤집기 방법을 사용해보자
	public static boolean isPalindrome(int num) {
		boolean result = true; // 일단은 대칭수라고 가정
		String t = num+""; // String으로 변경
		for(int i = 0; i < t.length()/2; i++) {
			if(t.charAt(i) != t.charAt(t.length()-1-i)) { // 앞에서 i번째 글자와 뒤에서 i번째 글자가 다르다면 대칭수가 아니다.
				result = false; // 대칭수 아니라고 표시
				break;
			}
		}
		return result;
	}

}
