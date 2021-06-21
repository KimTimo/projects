/*
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class ArrayEx04 {

	final static int MAX = 5;

	public static void main(String[] args) {
		int[][] arr = new int[MAX][MAX];
		// 초기화
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = i * arr.length + 1 + j;
			}
		}
		// 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("90도 시계방향으로 돌려서 출력");
		/*
		 * 7 4 1   --- [2][0] [1][0] [0][0]
		 * 8 5 2   --- [2][1] [1][1] [0][1]
		 * 7 4 1   --- [2][2] [1][2] [0][2]
		 */

		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[arr[i].length-j-1][i]);
			}
			System.out.println();
		}
		
		System.out.println("180도 시계방향으로 돌려서 출력");
		/*
		 * 9 8 7   --- [2][2] [2][1] [2][0]
		 * 6 5 4   --- [1][2] [1][1] [1][0]
		 * 3 2 1   --- [0][2] [0][1] [0][0]
		 */
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[arr[i].length-i-1][arr[i].length-j-1]);
			}
			System.out.println();
		}
		
		System.out.println("270도 시계방향으로 돌려서 출력");
		/*
		 * 3 6 9   --- [0][2] [1][2] [2][2]
		 * 2 5 8   --- [0][1] [1][1] [2][1]
		 * 1 4 7   --- [0][0] [1][0] [2][0]
		 */
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[j][ arr[i].length-i-1]);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
	}

}
