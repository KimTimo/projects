import java.util.Calendar;
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
public class Ex24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("년월일을 공백으로 구분하여 입력하시오(년도가 0이면 종료)");
			int yy = sc.nextInt();
			if (yy == 0)
				break;
			int mm = sc.nextInt();
			int dd = sc.nextInt();
			int sumday = getSumDay(yy, mm, dd);

			System.out.println(yy + " 년 " + mm + "월 " + dd + "일까지의 총일수는 " + sumday + "일 입니다,");
			String week = "일월화수목금토";
			System.out.println(week.charAt(sumday % 7) + "요일 입니다.");

			// 컴퓨터에서 오늘의 날짜를 구해서 넣어보자
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);

			System.out.println("오늘의 날짜는 " + year + " 년 " + month + "월 " + day + "일 입니다,");
			System.out.println("오늘까지의 총일수 : " + getSumDay(year, month, day) + "일");
			System.out.println("오늘의 요일 : " + week.charAt(getSumDay(year, month, day)%7) + "요일");
			System.out.println("당신이 살아온 일수는 " + (getSumDay(year, month, day) - sumday + 1) + "일 입니다.");
		}
		sc.close();
	} // close main

	private static int getSumDay(int yy, int mm, int dd) {
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
		return sumday;
	}
} // close class