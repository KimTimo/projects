package kr.green.utildate;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex03_Date {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		Date date = new Date();
		
		Method[] methods = date.getClass().getMethods();
		for(Method m : methods) {
			if(m.getName().startsWith("get"))
				System.out.println(m.getName() + " : " + m);
		}
		System.out.println();
		for(Method m : methods) {
			if(m.getName().startsWith("set"))
				System.out.println(m.getName() + " : " + m);
		}
		System.out.println();
		
		System.out.println("getYear() : " + date.getYear());
		System.out.println("getMonth() : " + date.getMonth());
		System.out.println("getDate() : " + date.getDate());
		System.out.println("getDay() : " + date.getDay());
		System.out.println("getHours() : " + date.getHours());
		System.out.println("getMinutes() : " + date.getMinutes());
		System.out.println("getSeconds() : " + date.getSeconds());
		System.out.println("getTime() : " + date.getTime());
		System.out.println("getTimezoneOffset() : " + date.getTimezoneOffset());
		System.out.println();
		System.out.println(sdf.format(date));
		date.setYear(100);
		System.out.println(sdf.format(date));
		date.setMonth(0);
		System.out.println(sdf.format(date));
		date.setDate(1);
		System.out.println(sdf.format(date));
		date.setHours(1);
		System.out.println(sdf.format(date));
		date.setMinutes(1);
		System.out.println(sdf.format(date));
		date.setSeconds(1);
		System.out.println(sdf.format(date));
		date.setTime(1000); // 1초
		System.out.println(sdf.format(date));
		date.setTime(1000 * 60 * 60); // 1시간
		System.out.println(sdf.format(date));
		date.setTime(1000 * 60 * 60 * 24L); // 1일
		System.out.println(sdf.format(date));
		date.setTime(1000 * 60 * 60 * 24L * 365); // 1년
		System.out.println(sdf.format(date));
	}
}
