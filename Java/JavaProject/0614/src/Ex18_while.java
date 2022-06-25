import java.util.Scanner;

/*
 while(조건){ 조건이 참일동안 반복할 명령들 1줄이면 중괄호 생략가능}
 
 */
public class Ex18_while {

	public static void main(String[] args) {

		// 1~100 사이의 홀수합 구하기
		// 1~100 사이의 짝수합 구하기
		// 1~100 사이의 홀수합/짝수합/전체합을 반복문으로 구하기
		int oddSum, evenSum, sum, i;
		
		i = 1;
		oddSum = 0;
		while(i<100) {
			oddSum += i;
			i+= 2;
		}
		System.out.println("홀수 합 : " + oddSum);
		
		i = 2;
		evenSum = 0;
		while(i<=100) {
			evenSum += i;
			i+= 2;
		}
		System.out.println("짝수 합 : " + evenSum);
		oddSum = evenSum = i = 0;
		while(i<=100) {
			i++;
			oddSum += i;
			++i;
			evenSum += i;
		}
		sum = oddSum + evenSum;
		System.out.println("홀수 합 : " + oddSum);
		System.out.println("짝수 합 : " + evenSum);
		System.out.println("전체 합 : " + sum);
		
		
		
		
		
	} // close main
	
	

} // close class
