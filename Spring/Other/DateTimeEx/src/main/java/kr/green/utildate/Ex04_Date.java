package kr.green.utildate;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * public boolean after(Date when)
 * public boolean before(Date when)
 */
public class Ex04_Date {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		Date date1 = new Date();
		Date date2 = new Date();
		date2.setDate(1);
		System.out.println("날짜 1 : " + sdf.format(date1));
		System.out.println("날짜 2 : " + sdf.format(date2));
		
		System.out.println("date1.after(date2) : " + date1.after(date2));
		System.out.println("date1.before(date2) : " + date1.before(date2));
		System.out.println("date2.after(date1) : " + date2.after(date1));
		System.out.println("date2.before(date1) : " + date2.before(date1));

	}
}
