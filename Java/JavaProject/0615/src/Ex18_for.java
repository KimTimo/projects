/*
 * for 반복문
 */
/*
 *문제
 *----
 *1~10000 까지의 8의 개수는?
 */

public class Ex18_for {
	public static void main(String[] args) {

		int count = 0;
		for (int i = 1; i <= 10000; i++) { // 1~10000까지 반복
			int temp = i;                  // i값이 내부에서 변하면 반복 횟수에 영향을 주므로 피신
			while (temp > 0) {             // 0보다 클때까지
					if (temp % 10 == 8)        
						count++;           // 마지막 1자리를 잘라 8이면 개수 증가
				temp /= 10;                // 마지막 자리 버리기
			}
		}
		System.out.println("1~10000까지의 8의 개수 : " + count + "개 입니다.");

	} // close main
} // close class