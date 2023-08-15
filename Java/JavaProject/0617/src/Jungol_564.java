import java.util.Scanner;

public class Jungol_564 {

	public static void main(String[] args) {

		String ar[] = new String[100]; // 입력되는 글자수
		int cnt[] = new int[26]; // 갯수를 세어서 넣을 배열
		Scanner sc = new Scanner(System.in);
		int index = 0;
		
		do {
			ar[index] = sc.next();
			index++;
		} while (ar[index - 1].charAt(0) >= 'A' && ar[index - 1].charAt(0) <= 'Z');

		index -= 2; // 마지막에 1 증가되었으니 제외 마지막 입력글자는 대문자가 아니니까 제외

		//for (int i = 0; i <= index; i++) System.out.println(ar[i]);
		
		// 개수를 세어 보자
		for(int i = 0; i <= index; i++) // 이게 포인트이다.
			cnt[ar[i].charAt(0)-'A']++;

		// 출력해보자!!!
		for(int i = 0; i <cnt.length; i++) {
			if(cnt[i]!=0) {
				System.out.println((char)(i + 'A') + " : " + cnt[i]);
			}
		}
		
		sc.close();
	}

}
