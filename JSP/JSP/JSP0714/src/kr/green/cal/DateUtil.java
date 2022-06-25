package kr.green.cal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	static Calendar calendar = Calendar.getInstance();
	// 현재 연도를 리턴하는 메서드
	public static int getYear() {
		return calendar.get(Calendar.YEAR);
	}
	// 현재 월을 리턴하는 메서드
	public static int getMonth() {
		return calendar.get(Calendar.MONTH) + 1;
	}
	// 현재 일을 리턴하는 메서드
	public static int getDate() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	// 오늘의 날짜를 알려주는 메서드
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		return sdf.format(calendar.getTime());
	}
	// 현재 시간을 알려주는 메서드
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh시 mm분 ss초");
		return sdf.format(calendar.getTime());
	}
	// 윤년을 판단하는 메서드
	public static boolean isLeapYear(int year) {
		return year%400==0 || year%4==0 && year%100!=0;
	}
	// 월의 마지막 날짜를 리턴하는 메서드
	public static int getLastday(int year, int month) {
		int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		m[1] = isLeapYear(year) ? 29 : 28;
		return m[month-1];
	}
	// 1년 1월 1일 부터 지정날짜까지의 총일 수를 리턴하는 메서드
	public static int getTotalDay(int year, int month, int date) {
		int sum = (year-1) * 365 + (year-1)/4 - (year-1)/100 + (year-1)/400; // 전년도까지의 일 수
		for(int i=1;i<month;i++) sum += getLastday(year, i); // 전월까지의 일수
		sum += date;
		return sum;
	}
	// 요일을 숫자로 리턴하는 메서드
	public static int getWeekDay(int year, int month, int date) {
		return getTotalDay(year, month, date)%7;
	}
	// 요일을 문자열로 리턴하는 메서드
	public static String getWeekDayStr(int year, int month, int date) {
		return "일월화수목금토".charAt(getWeekDay(year, month, date))+"";
	}
	// 지정 년월의 달력을 출력하는 메서드
	public static void viewCalendar(int year, int month) {
		System.out.printf("\n%18d년 %02d월\n\n", year, month);
		System.out.println("   일   월   화   수   목   금   토");
		for(int i=0;i<getWeekDay(year, month, 1);i++) // 1일의 요일을 맞추기 위해서 공백을 출력
			System.out.print("     ");
		// 1일부터 마지막 날짜까지 출력한다. 단, 토요일이면 줄바꾼다.
		for(int i=1;i<=getLastday(year, month);i++) {
			System.out.printf("%5d", i);
			if(getWeekDay(year, month, i)==6) System.out.println(); // 토요일이면 줄바꿈
		}
		System.out.println("\n\n");
	}
}
