package loopexample;

public class WhileExample2 {

	public static void main(String[] args) {

		int num = 1;
		int sum = 0;
		
		do {
			sum += num;
			num++;
		}while(num <= 0); //조건식이 나중에 수행되기 때문에 코드가 한번은 실행된다. 그래서 결과값이 1이 출력됨.
		
		System.out.println("1부터 10까지의 합은 " +sum+ "입니다.");
	}

}
