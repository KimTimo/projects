/*
 while(조건){ 조건이 참일동안 반복할 명령들 1줄이면 중괄호 생략가능}
 
 */
public class Ex16_while {

	public static void main(String[] args) {

		//1~100까지 합을 출력하시오
		//1~100까지 증가하는 증가변수, 누적변수 필요
		
		
		int i = 1;
		int sum = 0;
		while(i<=100) {
			sum += i++;
		}
		System.out.println("1~100까지 합 : " + sum);
		System.out.println("---------------------");
		sum = i = 0;
		do {
			sum += ++i;
		}while(i<100);
		System.out.println("1~100까지 합 : " + sum);
		System.out.println("---------------------");
	}

}
