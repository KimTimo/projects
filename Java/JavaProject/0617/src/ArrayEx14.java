import java.util.Random;

/*
 * 2행 10열의 배열을 만들어
 * 1행은 0~100사이의 난수로 채우고
 * 2행에는 숭위를 구해서 출력하는 프로그램을 작성하시오.
 */
public class ArrayEx14 {

	public static void main(String[] args) {

		int arr[][] = new int[2][10];

		Random rnd = new Random();
		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = rnd.nextInt(101);
			arr[1][i] = 1;
		}
		
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[0][i]<arr[0][j]) arr[1][i]++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}
	}

}
