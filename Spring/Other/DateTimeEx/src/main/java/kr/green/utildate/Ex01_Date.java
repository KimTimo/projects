package kr.green.utildate;

import java.util.Date;

public class Ex01_Date {
	public static void main(String[] args) {
		// 생성자 1
		Date date1 = new Date(); // 오늘 날짜

		long msec1 = date1.getTime();
		long msec2 = System.currentTimeMillis();
		System.out.println("1970년 1월 1일 9:00:00 이후 밀리초 : " + msec1);
		System.out.println("1970년 1월 1일 9:00:00 이후 밀리초 : " + msec2);

		// 생성자 2
		Date date2 = new Date(msec2); // 오늘 날짜
		System.out.println("날짜 1 : " + date1);
		System.out.println("날짜 2 : " + date2);
		
	}
}
