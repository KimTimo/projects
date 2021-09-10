/*
 * 반복문의 중첩
 */
public class Ex03 {

	public static void main(String[] args) {

		int i, j;
		i = j = 0;
		while (i < 10) {
			j = 0;
			while (j < 10) {
				System.out.print("★");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println();
		
		i = j = 0;
		while (i < 10) {
			j = 0;
			while (j <= i) {
				System.out.print("★");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println();
		
		i = j = 0;
		while (i < 10) {
			j = 0;
			while (j <= 9 - i) {
				System.out.print("★");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println();
		
		
	}

}
