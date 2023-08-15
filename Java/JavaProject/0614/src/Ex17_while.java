import java.util.Scanner;

/*
 while(조건){ 조건이 참일동안 반복할 명령들 1줄이면 중괄호 생략가능}
 
 */
public class Ex17_while {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = 1, sum=0, count = 0; // 입력변수, 합계변수, 개수 변수
		double avg; // 평균변수
		System.out.println("정수를 여러개 입력하시오 마지막에 0을 넣으면 종료합니다. ");
		while(n!=0) {
			n = scanner.nextInt();
			sum += n;
			count++;
		}
		count--; // 마지막 0은 제외시킨다. 
		avg = (double)sum/count;
		System.out.println("합계 :  " + sum);
		System.out.println("평균 :  " + avg);

		
		scanner.close();
		
	}

}
