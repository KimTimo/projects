
public class Dojang_530 {

	public static void main(String[] args) {
		for(int i = 5; i <= 10000; i++) {
			viewPerfectNumber(i);
		}

		
		System.out.println(multiplesOf3and5(10));
		System.out.println(multiplesOf3and5(1000));
	}

	
	public static int multiplesOf3and5(int n) {
		int sum = 0;
		for(int i = 1; i < n; i++) {
			if(i%3==0 || i%5==0) sum += i;
		}
		return sum;
	}
	
	public static void viewPerfectNumber(int n) {
		int sum = 0;
		for(int j = 1; j < n; j++) {
			if(n % j == 0) {
				sum += j;
			}
		}
	}
	
}
