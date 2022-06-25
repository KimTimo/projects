import java.util.Scanner;

/*
 * JDK 1.5에 추가된 향상된 for 반복문
 * ----------------------------------
 * for(변수 : 컬렉션){
 *     컬렉션의 내용이 1개씩 변수로 복사되어 끝날때까지 반복
 *     }
 * Collection : 자료들의 집합
 */

 

public class Ex22_for {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(;;) { // 무한루프
			System.out.println("정수 입력(0은 종료) : ");
			int n = sc.nextInt();
			if(n==0) break;
			int len = 1;
			for(char i : (n+"").toCharArray()) {
				len *= 10;
			}
			len /= 10;
			System.out.println("자릿수 : " + len);
		}
		
		sc.close();
	} // close main
} // close class