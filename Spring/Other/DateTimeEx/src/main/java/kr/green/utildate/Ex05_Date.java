package kr.green.utildate;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * public Object clone()
 */
public class Ex05_Date {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		Date date1 = new Date();
		Date date2 = (Date) date1.clone();
		Date date3 = date1;
		
		System.out.println(sdf.format(date1) + " : " + date1.hashCode());
		System.out.println(sdf.format(date2) + " : " + date2.hashCode());
		System.out.println(sdf.format(date3) + " : " + date3.hashCode());
		System.out.println();
		
		date1.setDate(1);
		System.out.println(sdf.format(date1) + " : " + date1.hashCode());
		System.out.println(sdf.format(date2) + " : " + date2.hashCode());
		System.out.println(sdf.format(date3) + " : " + date3.hashCode());
		System.out.println();

		date2.setDate(1);
		System.out.println(sdf.format(date1) + " : " + date1.hashCode());
		System.out.println(sdf.format(date2) + " : " + date2.hashCode());
		System.out.println(sdf.format(date3) + " : " + date3.hashCode());
		System.out.println();
		
		System.out.println("compareTo");
		System.out.println(sdf.format(date1));
		System.out.println(sdf.format(date2));
		System.out.println(sdf.format(date3));
		// 0, -1, 1
		System.out.println(date1.compareTo(date2));
		System.out.println(date1.compareTo(date3));
		System.out.println(date3.compareTo(date2));
		System.out.println();
		
		date1.setDate(2);
		System.out.println(sdf.format(date1));
		System.out.println(sdf.format(date2));
		System.out.println(date1.compareTo(date2));
		System.out.println(date2.compareTo(date1));
		System.out.println();
		
		// equals
		System.out.println("equals");
		System.out.println(sdf.format(date1));
		System.out.println(sdf.format(date2));
		System.out.println(sdf.format(date3));
		System.out.println(date1.equals(date2));
		System.out.println(date2.equals(date1));
		System.out.println(date1.equals(date3));
		
	}
}
