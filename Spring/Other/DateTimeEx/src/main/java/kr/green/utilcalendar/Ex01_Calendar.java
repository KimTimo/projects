package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex01_Calendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		// Calendar를 Date로 변환
		Date date = calendar.getTime();
		
		System.out.println(calendar);
		System.out.println(date);
		System.out.println(sdf.format(date));
		
		Calendar calendar2 = Calendar.getInstance();
		// Date를 Calendar로 변환
		calendar2.setTime(new Date(System.currentTimeMillis()));
		System.out.println(sdf.format(calendar2.getTime()));
	}
}
