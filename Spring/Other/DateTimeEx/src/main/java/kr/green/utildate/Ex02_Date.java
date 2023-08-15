package kr.green.utildate;

import java.text.SimpleDateFormat;
import java.util.Date;
// @Deprecated 태그는 클래스나 메소드 등을 더 이상 사용이 권장하지 않는 경우에 사용한다. 
// 사용이 권장되지 않는다는 것은 사용을 불가능하다는 것은 아니다. 다만 권장을 하지 않고 차후에 없어질 수도 있다는 것을 의미한다.

public class Ex02_Date {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date1 = new Date(1, 0, 1);
		// year  : 1900년 이후의 년 수 
		// month : 0 ~ 11
		// date  : 1-31.
		
		Date date2 = new Date(1, 0, 1, 1, 1);
		// hrs : 0~23
		// min : 0~59

		Date date3 = new Date(1, 0, 1, 1, 1, 1);
		// sec : 0~59
		
		Date date4 = new Date(1, 1, 31); // 2월 31일
		
		System.out.println("날짜 1 : " + date1);
		System.out.println("날짜 2 : " + date2);
		System.out.println("날짜 3 : " + date3);
		System.out.println("날짜 4 : " + date4);
		System.out.println();
		System.out.println("날짜 1 : " + sdf.format(date1));
		System.out.println("날짜 2 : " + sdf.format(date2));
		System.out.println("날짜 3 : " + sdf.format(date3));
		System.out.println("날짜 4 : " + sdf.format(date4));
	}
}
