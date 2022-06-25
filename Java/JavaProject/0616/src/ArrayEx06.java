import java.util.Arrays;
import java.util.Random;

/*
 * 문제 : 52장 카드를 섞어보자
 */
public class ArrayEx06 {

	public static void main(String[] args) {

		int card[] = new int[52];
		int temp; // 카드수
		Random rnd = new Random(); // 난수 생성
		for (int i = 0; i < card.length; i++) {
			do {
				temp = rnd.nextInt(card.length);
			} while (card[temp] != 0);
			card[temp] = i;
		}
		// 배열에 0~51까지 숫자가 섞이게 된다.
		System.out.println(Arrays.toString(card));

		String kind[] = "♠♥♣◆".split(""); // 문자열.split(구분자) : 문자열을 구분자로 분리하여 배열로 만든다.
		System.out.println(Arrays.toString(kind)); // 구분자를 주지 않으면 1글자씩 잘라서 배열로 만들어 준다.
		String[] nums = " 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K".split(",");
		System.out.println(Arrays.toString(nums));

		// 숫자를 카드로 바꿔서 출력해보자!!
		for (int i = 0; i < card.length; i++) {
			System.out.print(kind[card[i] / 13] + nums[card[i] % 13] + "       ");
			if ((i + 1) % 13 == 0)
				System.out.println(); // 1줄에 13개씩 출력
		}
		System.out.println();
		for (int i = 0; i < card.length; i++) {
			System.out.print(kind[i / 13] + nums[i % 13] + "(" + i + ")   ");
			if ((i + 1) % 13 == 0)
				System.out.println(); // 1줄에 13개씩 출력
		}
	} // close main

} // close class
