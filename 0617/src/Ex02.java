import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("주민번호를 입력하시오(-없이, 0은 종료) : ");
			String jnum = sc.next(); // 엔터를 칠 때까지 1줄을 입력받는다.
			if(jnum.equals("0")) break;
			if(jnum.length()!=13) {
				System.out.println("주민번호는 13자리여야 합니다.");
				continue;
			}
			try {
				Long.parseLong(jnum); // long형으로 변경해라. 에러가 발생하면 변경하지 못하는 문자가 있다는 뜻임.
			}catch(Exception e) {// 예외처리는 나중에 배움
				System.out.println("주민번호는 숫자로만 이루어져 있어야 합니다.");
				continue;
			}
			int sum = 0;
			for(int i = 0; i < jnum.length()-1; i++) {
				System.out.println(jnum.charAt(i) + " * " + (i+2)%8 + " = ?" + ((jnum.charAt(i)-'0') * (i%8+2)));
			}
			sum = (11-sum%11)%10;
			// 문자열.substring(시작위치) : 시작위치부터 끝까지
			// 문자열.substring(시작위치, 종료위치) : 시작위치부터 종료위치 전까지를 가져온다.
			System.out.print(jnum.substring(0,6) + "-" + jnum.substring(6) + "은 ");
			if(sum+'0' == jnum.charAt(12)) {
				System.out.println("맞는 주민번호");
			} else {
				System.out.println(" 틀린 주민번호");
			}
			
		}
		
		
		sc.close();
	} 
} 
