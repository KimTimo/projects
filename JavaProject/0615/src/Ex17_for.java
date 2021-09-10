/*
 * for 반복문
 * ----------
 * for(초기식;종료식;증감식){
 *    종료식이 참인동안 실행할 명령들....
 * }
 * 
 * ;은 절대 생략할 수 없다.
 */

/*
 * 문제
 * A
 * BC
 * DEF
 * GHID
 * ..... 이렇게 20줄을 출력하시오
 * Z 다음에는 다시 A가 나타난다.
 * 
 */

public class Ex17_for {
	public static void main(String[] args) {
		for(char i='A'; i<'Z'; i++) {
			for(char j='A'; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
			System.out.println();
			int k = 0;
			for(int i = 0; i < 10; i++) {
				System.out.print(String.format("%02d줄 : ", i+1));
				for(int j = 0; j <= i; j++) {
					System.out.print((char)('A'+k++%26));
					k++;
				}
				System.out.println();
			}
		}

}