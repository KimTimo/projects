/*
 * 반복문의 중첩
 */
public class Ex02 {

	public static void main(String[] args) {

		int i, j;
		i = j = 0;
		while(i<10) {
			System.out.println("i = " + i + "번 실행");
			j = 0;
			while(j<10) {
				System.out.println("나는 j = " + j);
				j++;
			}
			i++;
		}
	}

}
