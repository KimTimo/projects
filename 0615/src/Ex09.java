
public class Ex09 {

	public static void main(String[] args) {

		int i, j;
		i = j = 1;
		while(i<=9) {
			j = 1;
			while(j<=9) {
				System.out.printf("%3d *%2d =%2d", j, i, i*j);
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
