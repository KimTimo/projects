/*
 Printing OXs
 ============
 input은 int n을 입력 받아 첫번째 row는 (n-1)의 O와 X, 두번째 row는 (n-2)의 O와 XX, 세번째 row는 (n-3)의 0와 XXX... n번째 row는 n의 X을 출력하시오.
 */
public class Ex08 {

	public static void main(String[] args) {
		printingOXs(6);
		printingOXs(10);
		printingOXs(20);

		
	}
	
	public static void printingOXs(int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print((j<n-i-1) ? "O":"X");
			}
			System.out.println();
		}
		System.out.println();
	}

}
