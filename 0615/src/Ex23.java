import java.util.Scanner;

/*
 * 문제]
 * 년월일을 입력받아 요일을 출력하는 프로그램을 작성하시오
 * 요일을 1년 1월 1일 부터 날짜의 총일수를 구하여
 * 7로 나누었을때 나머지가 0이면 일요일, 1이면 월요일 ... 6이면 토요일이다.
 * 1. 총일수를 구해야 한다. 어떻게 구할까?
 *    1) 전년도 까지의 총일수를 구한다.
 *    2) 전월까지의 총일수를 구한다.
 *    3) 총일수 = 1 + 2 + 일
 * 2. %7 해서 요일을 구하면 된다.
 */
public class Ex23 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("년월일을 공백으로 구분하여 입력하시오(년도가 0이면 종료)");
			int yy = sc.nextInt();
			if (yy == 0)
				break;
			int mm = sc.nextInt();
			int dd = sc.nextInt();
			// -----------------------------------------------------
			// 1) 전년도까지의 총일수를 구한다.
			int sumday = (yy - 1) * 365 + (yy - 1) / 4 - (yy - 1) / 100 + (yy - 1) / 400;
			// 2) 전년도까지의 총일수
			for (int i = 1; i < mm; i++) {
				if (i == 2) {
					sumday += (yy % 400 == 0 || yy % 4 == 0 && yy % 100 != 0) ? 29 : 28;
				} else if (i == 4 || i == 6 || i == 9 || i == 11) {
					sumday += 30;
				} else {
					sumday += 31;
				}
			}
			// 3) 총일수 = 1 + 2 + 일
			sumday += dd;

			System.out.println(yy + " 년 " + mm + "월 " + dd + "일까지의 총일수는 " + sumday + "일 입니다,");
			String week = "일월화수목금토";
			System.out.println(week.charAt(sumday % 7) + "요일 입니다.");
		}
		sc.close();
	} // close main
} // close class