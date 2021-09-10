/*
문제
배열을 만들어서 아래와 같이 저장한 후 출력하는 프로그램을 작성하시오. 
규칙은 첫 번째 행은 모두 1로 초기화 하고 다음 행부터는 바로 위의 값과 바로 왼쪽의 값을 더한 것이다.


출력 예
1  1  1  1  1
1  2  3  4  5
1  3  6 10 15
1  4 10 20 35
1  5 15 35 70

 */
public class Jungol_570 {
	public static void main(String[] args) {
		// int ar[][] = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 } };
		int ar[][] = new int[5][5];
		for(int i=0;i<ar.length;i++) {
			ar[i][0] = 1; // 첫번째 칸
			ar[0][i] = 1; // 첫번째 줄
		}

		for (int i = 1; i < ar.length; i++) {
			for (int j = 1; j < ar[i].length; j++) {
				//         위         + 왼쪽   
				ar[i][j] = ar[i-1][j] + ar[i][j-1]; 
			}
		}
		// 출력
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.printf("%5d", ar[i][j]);
			}
			System.out.println();
		}

	}
}
