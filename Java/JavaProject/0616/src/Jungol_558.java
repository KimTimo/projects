import java.util.Scanner;

public class Jungol_558 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
		int i = 0;
		
		do {
			arr[i] = sc.nextInt();
			i++;
		}while(arr[i-1]!=0);
		// 0을 제외하고
		i--; // 0입력하고 1증가 했으니 1을 뺀다.
		
		do {
			i--; // 1씩 줄어들면서
			System.out.print(arr[i] + " ");
		}while(i>0);
		
		sc.close();
	}
	

}
