package kr.green.maven0625.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date1 {

	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today);
		System.out.println(today.getTime());
		System.out.println();
		
		System.out.println(today.getYear());
		System.out.println(today.getMonth());
		System.out.println(today.getDate());
		System.out.println(today.getDay());
		System.out.println();
		
		System.out.println(today.getHours());
		System.out.println(today.getMinutes());
		System.out.println(today.getSeconds());
		
		Date date = new Date(1900, 0, 1, 0, 0);
		System.out.println(date.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) hh:mm:ss ");
		System.out.println(sdf.format(today));
		System.out.println(sdf.format(date));
		
	}

}
