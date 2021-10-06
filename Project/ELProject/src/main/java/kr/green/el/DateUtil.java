package kr.green.el;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	// static으로 자주 사용하는 메서드를 만들어 준다. 리턴 타입은 String이다.
	public static String getDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E요일)");
		return sdf.format(date);
	}

	public static String getTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.S");
		return sdf.format(date);
	}
}
