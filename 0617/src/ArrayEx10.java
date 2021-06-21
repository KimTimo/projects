// 문제 : 배열을 달팽이로 채우기
/*
 25 24 23 22 21
 10  9  8  7 20
 11  2  1  6 19
 12  3  4  5 18
 13 14 15 16 17
 */
public class ArrayEx10 {
	public static void main(String[] args) {
		final int MAX = 5; // 상수 선언 (배열의 크기를 지정)
		int ar[][] = new int[MAX][MAX];
		// 개수, 증가. 행, 열, 반전
		int count=MAX, k=MAX*MAX, row=0, col=-1, sw=1; 

		while(true){
			for(int i=0;i<count;i++){
				col += sw;
				ar[row][col] = k--; // 열 증감
			}

			// 개수감소. 개수가 0이면 모두 채웠다. 종료 
			if(--count==0) break; // /대각선에서 개수 감소

			for(int i=0;i<count;i++){
				row += sw;
				ar[row][col] = k--;
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