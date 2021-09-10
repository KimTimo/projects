/*
 while(조건){ 조건이 참일동안 반복할 명령들 1줄이면 중괄호 생략가능}
 
 */
public class Ex15_while {

	public static void main(String[] args) {

		boolean flag = false;
		
		while(flag){ //초기식이 거짓이면 1회도 실행되지 않는다.
			System.out.println("나는 실행이 될까요?(while)");
		}
		
		
		
		do{ // 초기식이 거짓이어도 1회는 반드시 실행된다.
			System.out.println("나는 실행이 될까요?(do ~ while)");
		}while(flag);

	}

}
