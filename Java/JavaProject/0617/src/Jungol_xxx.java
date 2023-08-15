import java.util.Scanner;

public class Jungol_xxx {

	public static void main(String[] args) {

		System.out.println("양수 음수 판별 프로그램");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		// int y = sc.nextInt();

		if (x > 0) {
			System.out.println(x + "\n" + "plus");
		} else if (x < 0) {
			System.out.println(x + "\n" + "minus");
		}

		sc.close();
	}

}
