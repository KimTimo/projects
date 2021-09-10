import java.util.Scanner;

/*
 * 100 이하의 자연수를 입력받아 첫 번째 항은 100으로 두 번째 항은 입력받은 수로 초기화하고
 * 다음 항부터는 전전항에서 전항을 뺀 수로 채워나가는 수열을 작성하여 그 수가 음수가 나올 
 * 때까지 출력하는 프로그램을 작성하시오.
 */
public class Jungol_566 {

	public static void main(String[] args) {

		int cnt[] = new int[100];
		int num[] = new int[50];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < cnt.length; i++) {
			for(int j = 0; j < cnt[i]; j++) {
				System.out.println(j);
			}
		}
		
		
		
		
		
		
		sc.close();
	}

}
