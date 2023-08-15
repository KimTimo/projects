import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int arr[] = {2, 6, 4, 7};
		for(int i = 0; i < arr.length; i++) {
			int m = 1; // 합은 0으로 곱은 1로 초기화
			for(int j = 0; j < arr.length; j++) {
				if(i!=j) m *= arr[j];
			}
			System.out.printf("%4d", m);
		}
		sc.close();
	} 
} 
