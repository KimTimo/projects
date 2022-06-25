import java.util.Arrays;
import java.util.Random;

/*
 * 문제 : 학생 21명이 있다. 체육대회를 하기 위하여 3개의 팀으로 만들려고 한다.
 *        무작위로 추첨하여 팀을 만들어 출력하시오.
 */
public class ArrayEx04 {

	public static void main(String[] args) {

		int player[] = new int[20];
		Random rnd = new Random();
		int team = 5, temp;

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
