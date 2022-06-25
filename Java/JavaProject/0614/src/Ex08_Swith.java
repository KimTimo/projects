import java.util.Scanner;

public class Ex08_Swith {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("수식을 입력하세요 예) 4 * 6 (0은 종료)");
			int num1 = sc.nextInt();
			if(num1==0) break;
			String op = sc.next();
			int num2 = sc.nextInt();
			
			int result;
			switch(op.charAt(0)) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			default :
				result = 0;
				break;
			}
			System.out.println(num1 + " " + op + " " + num2 + " = " + result);
		} // end while
		sc.close();
	} // end main
} // end class
