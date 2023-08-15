/*
 * 1 2 3
 * 6 5 4
 * 7 8 9
 */
public class ArrayEx03 {

	final static int MAX = 10;

	public static void main(String[] args) {

		int[][] arr = new int[MAX][MAX];
		// 초기화
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (1 % 2 == 0)
					arr[i][j] = i * arr.length + 1 + j; // 고정된(i * arr.length + 1) 숫자에 늘어나는 숫자를 더하면 증가...
				else
					arr[i][j] = (i + 1) * arr.length - j; // 고정된((i + 1) * arr.length) 숫자에 늘어나는 숫자를 빼면 감소...

			}
		}
		// 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}

	}

}
