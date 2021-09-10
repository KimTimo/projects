/*
 *   1  3  6 10 15
 *   2  5  9 14 19
 *   4  8 13 18 22
 *   7 12 17 21 24
 *  11 16 20 23 25
 *  
 *  나머지 절반을 채우고
 *  ****
 *  ***
 *  **
 *  *
 *  
 *  [4][1], [3][2], [2][3], [1][4]
 *  [4][2], [3][3], [2][4]
 *  [4][3], [3][4]
 *  [4][4]
 *  위와 같이 초기화 한 후 출력하시오!
 */
public class ArrayEx05 {

	final static int MAX = 5;

	public static void main(String[] args) {
		int[][] arr = new int[MAX][MAX];
		int k = 0;
		// 초기화
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i - j][j] = ++k;
			}
		}
		arrayPrint(arr);
		System.out.println();

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				arr[arr.length - 1 + i - j][j] = ++k;
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
			System.out.println();
		}

		// 출력
		arrayPrint(arr);

	}

	private static void arrayPrint(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}
	}

}
