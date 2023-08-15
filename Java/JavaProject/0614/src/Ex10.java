import java.util.Scanner;

// 년/월을 입력받아 그 달의 마지막 날짜를 출력하는 프로그램을 작성하시오.
// 변수는 ? year, month, lastDay, scanner
public class Ex10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("년월을 입력하시오");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int lastDay = 31; // 제일 많은 값으로 초기화 하자
		// if로 풀어보자
		if(month==2) {
			lastDay = year%400==0 || year%4==0 && year%100!=0 ? 29 : 28;
		}else if(month==4 || month==6 || month==9 || month==11) {
			lastDay = 30;
		}
		System.out.println(year + "년 " + month + "월의 마지막 날짜는 " + lastDay + "일입니다.");
		// switch로 풀면
		lastDay = 31;
		switch(month) {
		case 2:
		    lastDay = year%400==0 || year%4==0 && year%100!=0 ? 29 : 28;
		    break;
		case 4: case 6: case 9: case 11:
			lastDay = 30;
			break;
			
		}
		
		
		
		
		scanner.close();
	}

}
