package kr.green.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	 public static String getToday() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
			Date today = new Date();
			return sdf.format(today);
		}
}
