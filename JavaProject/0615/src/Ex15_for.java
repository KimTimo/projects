/*
 * for 반복문
 * ----------
 * for(초기식;종료식;증감식){
 *    종료식이 참인동안 실행할 명령들....
 * }
 * 
 * ;은 절대 생략할 수 없다.
 */
public class Ex15_for {
	public static void main(String[] args) {
		int count = 0;

		start: for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0)
					continue start;
			}
			System.out.printf("%4d", i);
			if (++count % 5 == 0)
				System.out.println();
		}

	}
}