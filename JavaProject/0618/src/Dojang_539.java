import java.util.Scanner;

public class Dojang_539 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		viewPerfectNumber(num);
		sc.close();
	}

	private static void viewPerfectNumber(int num) {
		for (int i = 1; i <= num; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum += j;
				}
				if (i == sum) {
					System.out.println(i);
				}

			}

		}
	}
}