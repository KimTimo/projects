import java.util.Scanner;

/*
 * for 반복문
 */
/*
 *문제
 *----
 *정수를 2개 입력하여 앞의 숫자를 뒤집어 더하기를 뒤에 숫자만큼 수행하여 결과를 출력.
 *예)
 * 입력 : 1 10
 * 처리
 * 1 + 1 = 2 ---- 1
 * 2 + 2 = 4 ---- 2
 * 4 + 4 = 8 ---- 3
 * 8 + 8 = 16 ---- 4
 * 16 + 61 = 77 ---- 5
 * 77 + 77 = 154 ---- 6
 * 154 + 451 = 605 ---- 7
 * 605 + 506 = 1111 ---- 8
 * 1111 + 1111 = 2222 ---- 9
 * 2222 + 2222 = 4444 ---- 10
 * 
 */

public class Ex19_for {
	public static void main(String[] args) {
		System.out.println("정수 2개를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		while (y > 0) { // 두번째 수만큼 반복
			int len = 1; // 1. 첫번째 수의 자릿수를 구한다.
			int temp = x;
			while (temp >= 10) {
				len *= 10;
				temp /= 10;
			}
			System.out.println("자릿수 : " + len);
			// 2. 뒤집기
			int back = 0;
			temp = x;
			while (temp > 0) {
				back += temp % 10 * len;
				len /= 10;
				temp /= 10;
			}
			System.out.println(x + " : " + back);
			// 3. 원본 + 뒤집은 숫자
			x = x + back;

			//System.out.println(back + " + " + x );
			y--;

		}

		System.out.println("정답 : " + x);
		sc.close();

	} // close main
} // close class