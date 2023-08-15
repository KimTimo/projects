import java.util.Scanner;
/*
 숫자를 길게 문자열로 입력받아 숫자의 개수를 세는 프로그램
 */

public class Jungol_564_2 {

	public static void main(String[] args) {

		int cnt[] = new int[26]; // 갯수를 세어서 넣을 배열
		Scanner sc = new Scanner(System.in);
		
		System.out.print("긴 숫자 입력 : ");
		String str = sc.nextLine();
		//for (int i = 0; i <= index; i++) System.out.println(ar[i]);
		
		// 개수를 세어 보자
		for(int i = 0; i < str.length(); i++) // 이게 포인트이다.
			cnt[str.charAt(i)-'0']++;

		// 출력해보자!!!
		for(int i = 0; i <cnt.length; i++) {
			if(cnt[i]!=0) {
				System.out.println(i + " : " + cnt[i]);
			}
		}
		
		sc.close();
	}

}
