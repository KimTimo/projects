import java.util.Random;

/*
 * 10행 10열의 배열을 만들어
 * 9행 8열 까지는 0~100점 사이의 점수로 초기화하고 (여기서는 난수로)
 * 10행에는 세로합을 9열에는 가로합을 10열에는 석차를 구해서 출력하는 프로그램을 작성하시오.
 */
public class ArrayEx16 {

	public static void main(String[] args) {

		int arr[][] = new int[10][10];
		int sum = 0, avg = 0;

		Random rnd = new Random();
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr[i].length-2; j++) {
				arr[i][j] = rnd.nextInt(101);
				// 가로 합
				arr[i][arr[i].length-2] += arr[i][j];
				// 세로 합
				arr[arr.length-1][j] += arr[i][j];
			}
			// 석차는 처음에는 누구나 1등
			arr[i][arr[i].length-1] = 1;
		}
		// 석차 구하기
		for(int i = 0; i < arr[0].length-2; i++) {
			for(int j = i+1; j < arr.length-1; j++) {
				if(arr[i][arr[i].length-2] < arr[j][arr[i].length-2])
					arr[i][arr[i].length-1]++;
				else if(arr[i][arr[i].length-2] > arr[j][arr[i].length-2])
					arr[j][arr[i].length-1]++;
			}
		}
		// 출력
		// 가로로 계산된 모든 내용 출력
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%8d", arr[i][j]);
				// 현재 출력이 총점이라면 옆으로 평균을 출력한다.
				if(j==arr[i].length-2)
					System.out.printf("%8.2f", (double)arr[i][j]/(arr[i].length-2));
			}
			System.out.println();
		}
		// 과목 평균
		for (int i = 0; i < arr.length-2; i++) {
			System.out.printf("%8.2f", (double)arr[arr.length-1][i]/arr.length-1);
		}
	}

}
