/*
 * 재귀호출 : 자기 자신을 호출하는 메소드
 *            잘사용하면 약, 잘못사용하면 독! (양날의 검)
 */
public class Ex08_RecursiveCall2 {

	public static void main(String[] args) {
//		for (int i = 1; i <= 10; i++)
//			System.out.println(fibonacci(i) + " : " + recursiveFibonacci(i));
//		// 프로그램 실행시간 재는 방법
//		long start = System.nanoTime(); // 시작 시간 측정
//		System.out.println("50번째 피보나치 수열의 값 : " + fibonacci(50));
//		System.out.println("실행시간 : " + (System.nanoTime()-start) + "ns"); // 현재시간 - 시간시간
//		
//		
//		
//		start = System.nanoTime(); // 시작 시간 측정
//		System.out.println("50번째 피보나치 수열의 값 : " + recursiveFibonacci(50));
//		System.out.println("실행시간 : " + (System.nanoTime()-start) + "ns"); // 현재시간 - 시간시간
		
		fibonacci(5);
		System.out.println("----------------------------");
		recursiveFibonacci(5);
	}

	// n번째 피보나치 수열을 구하는 재귀호출 메서드 : 독이 되는 경우 - 너무 잦은 호출로 실행시간이 오래걸린다.
	static long recursiveFibonacci(int n) {
		System.out.println("recursiveFibonacci(" + n + ")호출"); // 이놈 추가
		return n == 1 || n == 2 ? 1 : recursiveFibonacci(n - 2) + recursiveFibonacci(n - 1);
	}

	// n번째 피보나치 수열을 구하는 일반 메서드
	static long fibonacci(int n) {
		System.out.println("recursiveFibonacci(" + n + ")호출"); // 이놈 추가
		long first = 0, second = 1;
		while (n>=2) {
			second = second + first;
			first = second - first;
			n--;
		}
		return second;
	}

}
