/*
  100까지의 자연수의 합의 제곱과 제곱의 합의 차이
 */
public class Ex01 {

	public static void main(String[] args) {

		int sum1 = 0, sum2 = 0;
		for (int i = 1; i <= 100; i++) {
			sum1 += i;
			sum2 += i * i;
		}
		System.out.println("합의 제곱 : " + sum1 * sum2);
		System.out.println("제곱의 합 : " + sum2);
		System.out.println("100까지의 자연수의 합의 제곱과 제곱의 합의 차이  : " + (sum1 * sum1 - sum2));
		
		Ex01 ex = new Ex01();
	}

}
