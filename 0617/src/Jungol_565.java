import java.util.Scanner;

/*
 숫자를 길게 문자열로 입력받아 숫자의 개수를 세는 프로그램
 */
public class Jungol_565 {

	public static void main(String[] args) {

		int cnt[] = new int[10]; // 갯수를 세어서 넣을 배열
		int ar[] = new int[100];
		Scanner sc = new Scanner(System.in);

		int idx = -1;// 0이 아니라 -1로 초기화하면
		do {
			++idx; // 증가되고 입력받으면 된다.
			ar[idx] = sc.nextInt();
		} while (ar[idx] != 0); // 여기에서 -1을 해주지 않아도 된다. 0이 입력될때 까지만 입력

		idx--; // 마지막 0은 제외
		for (int i = 0; i <= idx; i++)
			System.out.println(ar[i]);

		// 개수를 세어보자
		for (int i = 0; i <= idx; i++)
			cnt[ar[i] / 10]++;

		// 출력해보자
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > 0)
				System.out.println(i + " : " + cnt[i]);
		}

		sc.close();
	}

}
