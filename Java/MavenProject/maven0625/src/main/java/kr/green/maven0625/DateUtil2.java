package kr.green.maven0625;

public class DateUtil2 {
	// 윤년 판단하는 메소드
	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	// 월의 마지막 날짜를 리턴하는 메소드
	public static int getLatDay(int year, int month) {
		int[] m = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		m[1] = isLeapYear(year) ? 29 : 28;
		return m[month - 1];
	}
}
