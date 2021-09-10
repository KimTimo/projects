
public class Ex20_while {

	public static void main(String[] args) {

		// 1부터 계속 더해서 10000을 넘는 순간의 숫자와 합계를 출력하시오.
		
		int i = 0, sum = 0;
		do {
			++i;
			sum += i;
		} while(sum<10000);
		System.out.println(i + ", " + sum);
		
		i = 0;
		sum = 0;
		while(sum<10000) {
			++i;
			sum += i;
		}
		System.out.println(i + ", " + sum);
	}

}
