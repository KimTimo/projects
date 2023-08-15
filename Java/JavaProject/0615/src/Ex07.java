
public class Ex07 {

	public static void main(String[] args) {

		int i, j, sw, n;
		i = j = sw = n = 1;
			while (i <= 21) {
				j = 1;
				while (j <= 11 - n) {
					System.out.print(" ");
					j++;
				}
				j = 1;
				while (j <= n + 2 - 1) {
					System.out.print("*");
					j++;
				}
				System.out.println();
				n += sw;
				if (i == 10)
					sw *= -1;
				i++;

			}
		}
	}

