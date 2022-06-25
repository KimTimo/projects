import java.util.Scanner;

/*
 * 정수를 입력받아 첫 줄에 입력 받은 숫자를 출력하고 둘째 줄에 음수이면 
 *“minus” 라고 출력하는 프로그램을 작성하시오.
 */
public class Jungol_528 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n>=20)
			System.out.println("adult");
		else
			System.out.println((20-n) + "years later");
		
		scanner.close();
	}

}
