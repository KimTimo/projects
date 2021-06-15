import java.util.Scanner;

public class Ex04_If {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("년도를 입력하시오");
			int year = sc.nextInt();
			if(year==0) break;
			if(year<0) {
				System.out.println("년도는 양의 정수 이어야 합니다.");
				continue;
			}
			boolean isLeapYear = false;
			if(year%400==0 ) {
				isLeapYear = true;
			}else if(year%100!=0) {
				if(year%100!=0)
				isLeapYear = true;
			}
			System.out.println(year + "년은 " + (isLeapYear ? "윤" : "평") + "년 입니다.");
		}
		sc.close();
	}

}
