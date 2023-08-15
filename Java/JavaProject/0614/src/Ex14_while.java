
/*
 while(조건){ 조건이 참일동안 반복할 명령들 1줄이면 중괄호 생략가능}
 
 */
public class Ex14_while {

	public static void main(String[] args) {

		int i = 0;
		
		while(i<10) {
			System.out.print(++i + " ");
		}
		System.out.println();
		System.out.println("-------------------------");
		i=0;
		do {
			System.out.print(++i + " ");
		}while(i<10);
		System.out.println();
		System.out.println("-------------------------");
	}

}
