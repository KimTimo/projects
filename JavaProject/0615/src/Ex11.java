/*
 * 2~100까지의 소수를 1줄에 5개씩 출력하시오
 */
public class Ex11 {

	public static void main(String[] args) {

		int i = 2, count = 0;

		while (i <= 100) {

			int j = 2;
			while (i % j != 0) ++j; 
				// 나누어질 때까지 반복
				if (i == j) {
					System.out.printf("4%d", i);
					if (++count % 5 == 0)
						System.out.println();
				}
				i++;
			}

		}

	}


