package kr.green.utilcalendar;

import java.lang.reflect.Field;
import java.util.Calendar;

public class Ex05_Calendar {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();

		Field[] fields = calendar.getClass().getFields();
		for(Field field : fields) {
			System.out.println(field);
		}
		System.out.println();
	}
}
