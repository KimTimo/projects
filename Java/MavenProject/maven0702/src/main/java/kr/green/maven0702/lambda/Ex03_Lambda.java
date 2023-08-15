package kr.green.maven0702.lambda;

interface GenCalc {
	int calc(int n, int m);
}

public class Ex03_Lambda {
	public static void main(String[] args) {
		GenCalc max = new GenCalc() {

			@Override
			public int calc(int n, int m) {
				return n < m ? m : n;
			}
		};
		System.out.println("5와 10중 큰 값 : " + max.calc(5, 10));

		GenCalc min = new GenCalc() {

			@Override
			public int calc(int n, int m) {
				return n < m ? n : m;
			}
		};
		System.out.println("5와 10중 작은 값 : " + min.calc(5, 10));
		System.out.println("--------------------------------------");

		// 람다식으로 바꾸면 이렇게 된다.
		GenCalc max2 = (x, y) -> x < y ? y : x;
		GenCalc min2 = (x, y) -> x > y ? y : x;
		System.out.println("5와 10중 큰 값 : " + max2.calc(5, 10));
		System.out.println("5와 10중 작은 값 : " + min2.calc(5, 10));

		GenCalc SquareSum = new GenCalc() {

			@Override
			public int calc(int n, int m) {
				return n * n + m * m;
			}
		};
		System.out.println("--------------------------------------");
		System.out.println("5의 제곱과 10의 제곱의 합 : " + SquareSum.calc(5, 10));

		// 람다식으로 변환
		GenCalc SquareSum2 = (a, b) -> a * a + b * b;
		System.out.println("5의 제곱과 10의 제곱의 합 : " + SquareSum.calc(5, 10));

		GenCalc pythagoras = new GenCalc() {

			@Override
			public int calc(int n, int m) {
				return (int) Math.sqrt(n * n + m * m);
			}
		};
		System.out.println("밑변 4, 높이 3인 직각 삼각형의 빗변의 길이 : " + pythagoras.calc(3, 4));
		GenCalc pythagoras2 = (x, y) -> (int) Math.sqrt(x * x + y * y);
		System.out.println("밑변 4, 높이 3인 직각 삼각형의 빗변의 길이 : " + pythagoras.calc(3, 4));

	}

}
