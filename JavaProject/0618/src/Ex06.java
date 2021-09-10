import java.util.Scanner;

/*
 메모리공간을 동적으로 사용하여 데이터 관리하기
 프로그램 실행 순서
1. 입력할 정수의 개수를 사용자로부터 입력 받는다.
2. 입력받은 정수의 개수만큼 정수를 입력받는다.
3. 입력받은 정수의 합과 평균 값을 출력한다.
4. 할당된 메모리공간을 비운다.
 */
public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		System.out.print("입력할 정수의 개수 : ");
		int count = sc.nextInt();
		
		for(int i = 0; i < count; i++) {
			int num = sc.nextInt(); // 입력
			sum += num; // 합계
		}
		
		// 평균
		double avg = (double)sum/count;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
		
		
		sc.close();
	}

}
