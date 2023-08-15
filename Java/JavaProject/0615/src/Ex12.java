/*
 * 11번 에서는 n이 소수인지 판단하기 위해서 2~n까지의 숫자로 나누어 보아야 한다.
 * 그런데 2/n 초과의 수로는 절대로 나누어 떨어질 수 없다. 이 방법을 사용하면 반복 횟수를 1/2로 줄일 수 있다.
 */
public class Ex12 {

	public static void main(String[] args) {

		int i = 2, count = 0;

		while (i <= 100) {

			int j = 2;
			boolean flag = true;
			while (j <= i / 2) {
				if (i % j == 0) {
					flag = false;
					break;
				}
				++j;
			}
			if (flag) {
				System.out.printf("%4d", i);
				if (++count % 5 == 0)
					System.out.println();
			}
			i++;

		}
		System.out.println();

	}

}
