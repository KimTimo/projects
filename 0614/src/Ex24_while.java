import java.util.Scanner;

public class Ex24_while {

	public static void main(String[] args) {
		// 양의 정수를 입력하여 뒤에서부터 1자리씩 세로로 출력하시오.
		/*
		 * 예) 123
		 *       3
		 *       2 
		 *       1
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("양의 정수 입력.");
		int n = sc.nextInt();
		// 길이가 필요
		int length = 1;
		int temp = n;
		while(n > 10) { // 다 출력할 때까지 반복
			n /= 10; // 출력한 뒷자리 버리기
			length *= 10; // 버릴 때마다 10을 곱함.
		}
		System.out.println(length);
		// 앞자리부터 출력해보기
		n = temp;
		while(n>0) {
			System.out.println(n/length); // 몫 출력
			n %= length; // 나머지를 가지고
			length /= 10; // 나누는 숫자는 1000, 100, 10, 1처럼 1자리씩 줄어 들어야 한다.
		}
		sc.close();
		

		
		
		
		
		
		
		
		
		
	} // close main

} // close class
