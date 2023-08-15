package kr.green.exception1;

import java.util.InputMismatchException;
import java.util.Scanner;

// 두개의 정수를 입력받아 나눗셈의 결과를 보여주는 프로그램을 작성하시오.
// 자바의 예외처리 : try~catch~
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 예외가 발생할 소지가 조금이라도 있는 부분을 try블록으로 감싼다.
		try {
			System.out.println("첫번째 정수를 입력하세요.");
			int x = sc.nextInt();
			System.out.println("두번째 정수를 입력하세요.");
			int y = sc.nextInt();
			
			int result = x / y;
			System.out.println(x + "/" + y + "=" + result);
		// 발생이 예상되는 예외를 catch블록에서 잡아준다.
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("숫자로 정확하게 입력하세요ㅡㅡ");
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
			System.out.println("수학적으로 불가능한 계산입니다.");
		}catch(Exception e) {  // 예외는 우선순위가 있으므로 Exception을 catch로 적을 경우에는 catch의 제일 마지막에 써야한다.
			                   // 모든 예외의 조상 클래스가 Exception이기 때문이다.
			System.out.println(e.getMessage());
			System.out.println("알 수 없는 예외입니다.");
		// 예외와 상관없이 항상 실행되어야 하는 내용은 finally 블록에 써준다. 생략가능
		}finally {
			System.out.println("나는 항상 실행됩니다.");
		}
		
		sc.close();
	}

}
