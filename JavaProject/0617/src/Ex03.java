import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("사업자번 등록번호를 입력하시오(-없이, 0은 종료) : ");
			String jnum = sc.next(); // 엔터를 칠 때까지 1줄을 입력받는다.
			if(jnum.equals("0")) break;
			if(jnum.length()!=10) {
				System.out.println("사업자등록번호는 10자리여야 합니다.");
				continue;
			}
			try {
				Long.parseLong(jnum); // long형으로 변경해라. 에러가 발생하면 변경하지 못하는 문자가 있다는 뜻임.
			}catch(Exception e) {// 예외처리는 나중에 배움
				System.out.println("사업자등록번호는 숫자로만 이루어져 있어야 합니다.");
				continue;
			}
			
			int sum = 0;
			String mask = "137137135";
			for(int i = 0; i < mask.length(); i++) {
				sum += (jnum.charAt(i)-'0') * (mask.charAt(i)-'0');
			}
			sum += (jnum.charAt(8)-0) * 5 / 10;
			sum %= 10;
			sum = 10 - sum;
			
			if(sum + '0' == jnum.charAt(9)) {
				System.out.println("맞는 사업자 등록번홉입니다.");
			}else {
				
				System.out.println("맞는 사업자 등록번홉입니다.");
			}
			
		}
		
		
		sc.close();
	} 
} 
