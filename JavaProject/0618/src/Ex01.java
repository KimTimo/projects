
public class Ex01 {

	public static void main(String[] args) {

		int sum = 0;
		/*for(int i = 10; i <= 15; i++) {
			sum += i/10 * i%10;
		}
		*/
		
		
		for(int i = 10; i <= 1000; i++) {
			int m = 1;
			int temp = i;
			while(temp > 0) {
				m *= temp%10;
				temp /= 10;
			}
			sum += m;
		}
		System.out.println(sum);
	}

}
