// 문제 : 배열을 달팽이로 채우기
/*
  1  2  3  4  5
 16 17 18 19  6
 15 24 25 20  7
 14 23 22 21  8
 13 12 11 10  9
 */
public class ArrayEx13 {
	public static void main(String[] args) {
		final int MAX = 9; // 상수 선언 (배열의 크기를 지정)
		int ar[][] = new int[MAX][MAX];
		// 개수, 증가. 행, 열, 반전
		int count=MAX, k=0, row=MAX, col=MAX-1, sw=-1; 

		while(true){
			for(int i=0;i<count;i++){
				row += sw;
				ar[row][col] = ++k; // 열 증감
			}

			// 개수감소. 개수가 0이면 모두 채웠다. 종료 
			if(--count==0) break; // /대각선에서 개수 감소

			for(int i=0;i<count;i++){
				col += sw;
				ar[row][col] = ++k;
			}

			// 반전
			sw *= -1; // 대각선 위치에서 증감이 반전된다.
		}
		System.out.println("좌측 상단 시계 방향으로 달팽이 채우기");
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++)
				System.out.printf("%3d",ar[i][j]);
			System.out.println();
		}

	}
}