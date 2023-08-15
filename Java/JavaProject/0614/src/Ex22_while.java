
public class Ex22_while {

	public static void main(String[] args) {

		int first = 0, second = 1, count = 0, temp;
		do {
			System.out.printf("%10d", second);
			if(++count%5==0) System.out.println();
			temp = second;
			second += first;
			first = temp;
		}while(count<30);
		// 위의 풀이에서 temp의 용도는 무엇일까? 변하기 전의 second값을 기억하기 위해서 필요하다.
		// 변하기 전의 second값을 알아낼 수 있다면 temp가 필요없다. temp없이 풀어보자.
		first = 0; second = 1; count = 0;
		do {
			System.out.printf("%10d", second);
			if(++count%5==0) System.out.println();
			second += first;
			first = second - first;
		}while(count<30);
	}

}
