package kr.green.utilcalendar;

import java.util.Calendar;
import java.util.Locale;

// public static final int java.util.Calendar.SHORT : 1
// public static final int java.util.Calendar.LONG : 2
// public static final int java.util.Calendar.NARROW_FORMAT : 4
// public static final int java.util.Calendar.NARROW_STANDALONE
// public static final int java.util.Calendar.SHORT_FORMAT
// public static final int java.util.Calendar.LONG_FORMAT
// public static final int java.util.Calendar.SHORT_STANDALONE
// public static final int java.util.Calendar.LONG_STANDALONE
public class Ex10_Calendar {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);

	    String displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT_FORMAT, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT_STANDALONE, locale);
	    System.out.println(displayName);
	    System.out.println();
	    
	    displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_STANDALONE, locale);
	    System.out.println(displayName);
	    System.out.println();
	    
	    displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.NARROW_FORMAT, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.NARROW_STANDALONE, locale);
	    System.out.println(displayName);
	    System.out.println();

	    displayName = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.MONTH, Calendar.NARROW_FORMAT, locale);
	    System.out.println(displayName);
	    System.out.println();
	    
	    locale = Locale.GERMANY;
	    displayName = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
	    System.out.println(displayName);
	    displayName = calendar.getDisplayName(Calendar.MONTH, Calendar.NARROW_FORMAT, locale);
	    System.out.println(displayName);
	    System.out.println();
	}
}