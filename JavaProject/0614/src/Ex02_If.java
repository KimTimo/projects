import java.util.Scanner;

public class Ex02_If {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오");
		
		int n = sc.nextInt();
		String result = "";
		if(n%2==0) {
			result = "짝";
		} else if(n%2==1) {
			result = "홀";
		}
		System.out.println(n + "은 " + result);
		
		if(n>0) {
			result = "양수";
		}else if(n<0) {
			result = "음수";
		}else {
			result = "0";
		}
		System.out.println(n + "은 " + result + "입니다.");
		
		sc.close();
	}

}
