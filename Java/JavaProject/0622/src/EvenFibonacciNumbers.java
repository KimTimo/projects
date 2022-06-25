
public class EvenFibonacciNumbers {

	public static void main(String[] args) {
		System.out.println(evenFibonacciNumbers(40));
		System.out.println(evenFibonacciNumbers(400_0000));

	}
	
	public static int evenFibonacciNumbers(int n) {
		int sum = 0; // 더하면
		int first = 1, second = 2; // 1과 2로 시작
		while(first<=n) { // 어디까지
			if(first%2==0) sum += first; // 짝수이면 누적
			second += first;             // 뒤에 두개 더해서 두번째
			first = second - first;      // 첫번째에는 두번째것
		}
		return sum;
	}

}
