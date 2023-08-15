/*
 * 재귀호출 : 자기 자신을 호출하는 메소드
 *            잘사용하면 약, 잘못사용하면 독! (양날의 검)
 */
public class Ex07_RecursiveCall {

	public static void main(String[] args) {
//		show(); // StackOverflowError 발생
		System.out.println("1~100까지 합 : " + sum(100));
		System.out.println("1~100까지 합 : " + recursiveSum(100));
		
		
		System.out.println("5! =  " + factorial(5));
		System.out.println("5! =  " + recursiveFactorial(5));
		
		System.out.println("2의 1-승 : " + power(2, 10));
		System.out.println("2의 1-승 : " + recursivePower(2, 10));
	}
	/*
	    fac(5) --> 5 * fac(4)
	                   4 * fac(3)
	                       3 * fac(2)
	                           2 * fac(1)
	                                  1
	 */
	// x의 y승을 구하는 재귀호출 메서드
	static int recursivePower(int x, int y) {
		return y <= 1 ? x : x * recursivePower(x, y-1);
	}
	// x의 y승을 구하는 일반 메서드
	static int power(int x, int y) {
		int result = 1;
		for(int i = 1; i <= y; i++) result *= x;
		return result;
	}

	
	// n! 을 구하는 재귀호출 메서드
	static int recursiveFactorial(int n) {
		return n <= 1 ? 1 : n * recursiveFactorial(n - 1);
	}

	// n! 구하는 재귀호출 메서드
	static int factorial(int n) {
		int f = 1;
		while (n >= 1)
			f *= n--;
		return f;
	}
	
	// 1~n 까지 합을 구하는 일반 메서드
	static int recursiveSum(int n) {
		return n <= 0 ? 0 : n + recursiveSum(n - 1);
	}
	
	// 1~n 까지 합을 구하는 일반 메서드
	static int sum(int n) {
		int s = 0;
		while (n > 0)
			s += n--;
		return s;
	}

	public static void show() { // 무한 Loop에 빠짐. 반드시 종료식을 포함해야한다.
		System.out.println("난 재귀호출이라고 해~");
		// show(); // 자신을 부름
	}

}
