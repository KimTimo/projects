import java.util.Scanner;

/*
 while(조건){ 조건이 참일동안 반복할 명령들 1줄이면 중괄호 생략가능}
 
 */
public class Ex19_while {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n, sum=0, count = 0; // 입력변수, 합계변수, 개수 변수
		//do~while 에서는 n을 초기화 하지 않아도 된다. 왜? 지역변수는 반드시 초기화 되어야 한다.
		double avg; // 평균변수
		System.out.println("정수를 여러개 입력하시오 마지막에 0을 넣으면 종료합니다. ");
		do{
			n = scanner.nextInt(); //입력
			sum += n; // 누적
			count++; // 개수세고
		}while(n!=0); // 이 문장이 실행될때는 이미 n이 어떠한 값을 가졌기 때문에 초기화하지 않아도 된다.
		
		count--; // 마지막 0은 제외시킨다. 
		avg = (double)sum/count;
		System.out.println("합계 :  " + sum);
		System.out.println("평균 :  " + avg);

		
		scanner.close();
		
	}

}
