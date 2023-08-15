import java.util.Scanner;

public class Ex23_while {

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
		
		while(n > 0) { // 다 출력할 때까지 반복
			System.out.println(n%10); // 뒷자리 출력
			n /= 10; // 출력한 뒷자리 버리기
		}
		sc.close();
		

		
		
		
		
		
		
		
		
		
	} // close main

} // close class
