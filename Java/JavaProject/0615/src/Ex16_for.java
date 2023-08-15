/*
 * for 반복문
 * ----------
 * for(초기식;종료식;증감식){
 *    종료식이 참인동안 실행할 명령들....
 * }
 * 
 * ;은 절대 생략할 수 없다.
 */

// 문제] 1부터 계속 더했을때 합이 10000을 넘는 경우 마지막에 더해지는 수는?
public class Ex16_for {
	public static void main(String[] args) {
		int sum = 0, i;
		for (i = 1; sum < 10000; sum += i++) // for문 안에서 선언한 변수는 {} 밖에서 사용 못함
			System.out.println(i + ", " + sum);

		System.out.println();
		
		sum = 0;
		for (i = 1; sum < 1000; i += 2)
			sum += i;
		System.out.println(i + ", " + sum);

	}
}