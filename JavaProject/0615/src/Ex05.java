
public class Ex05 {

	public static void main(String[] args) {

		int i, j, sw;
		i = j = sw = 1;
		while (i <= 10) {
			j = 1;
			while (j <= 10 - i) {
				System.out.print("");
				j++;
			}
			j = 1;
			while (j <= i * 2 - 1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;

		}
		System.out.println();
	}

}
