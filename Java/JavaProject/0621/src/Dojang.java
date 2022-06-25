
public class Dojang {

	public static void main(String[] args) {

		for (int a = 1; a < 500; a++) {
			for (int b = a; b < 500; b++) { // a < b < c 라서 a 부터 시작
				int c = 1000 - (a + b); // a + b + C == 1000이라서 c를 계산
				if (a * a + b * b == c * c) {
					System.out.println(a + ", " + b + ", " + c);
				}
			}

		}

	}
}