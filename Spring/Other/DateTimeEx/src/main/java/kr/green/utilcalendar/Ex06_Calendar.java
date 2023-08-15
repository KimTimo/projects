package kr.green.utilcalendar;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

// public static final int java.util.Calendar.ALL_STYLES : 0
public class Ex06_Calendar {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Locale locale = Locale.getDefault();

	    Map<String, Integer> map = calendar.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.ALL_STYLES, locale);
	    for(String key : map.keySet()) {
	    	System.out.println(key + " : " + map.get(key));
	    }
	    System.out.println();
		
	    map = calendar.getDisplayNames(Calendar.MONTH, Calendar.ALL_STYLES, locale);
	    for(String key : map.keySet()) {
	    	System.out.println(key + " : " + map.get(key));
	    }
	    System.out.println();
	}
}
