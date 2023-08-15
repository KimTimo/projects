import java.util.Arrays;
import java.util.Random;

/*
 * 문제 : 20개의 배열에 1~10까지 숫자가 2개씩만 들어가게 초기화해서 출력
 */
public class ArrayEx05 {

	public static void main(String[] args) {

		int player[] = new int[20];
		Random rnd = new Random();
		int team = 10, temp;

		for (int i = 1; i <= team; i++) { // 3개팀
			for (int j = 0; j < player.length / team; j++) {
				do {
					temp = rnd.nextInt(player.length);
				} while (player[temp] != 0);
				player[temp] = i;
			}
			System.out.print(i + "번째 팀 : ");
			for (int j = 0; j < player.length; j++) {
				if (player[j] == i)
					System.out.printf("%3d", j + 1);
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(player));

	} // close main

} // close class
