package kr.green.utilcalendar;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Locale;

public class Ex11_Calendar {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		
		Method[] methods = calendar.getClass().getMethods();
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
	}
}