package kr.green.maven0625.datetime;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;

public class NumFormat {

	public static void main(String[] args) {
		// 숫자를 원하는 형식으로 출력하기
		double d = 123456789.123456789;
		
		System.out.println("d = " + d);
		
		DecimalFormat df = new DecimalFormat("#.##E0");
		System.out.println(df.format(d));
		System.out.println(df.format(123));
		System.out.println(df.format(123.8));
		
		System.out.println(new DecimalFormat("#,###.##").format(d));
		System.out.println(new DecimalFormat("#,###.##").format(56789));
		System.out.println(new DecimalFormat("#,###.##").format(56789.2));
		System.out.println(new DecimalFormat("#,###.##").format(56789.777));
		
		String str = "1,234.789";
		//System.out.println(Double.parseDouble(str)); // 숫자 이외의 문자열을 가지므로 에러발생
		DecimalFormat df2 = new DecimalFormat("#,###.###");
	    try {
			double dd = df2.parse(str).doubleValue();
			System.out.println(dd);
		} catch (ParseException e) {
			;
		}
	    
	    String name = "한사람";
	    int age = 33;
	    boolean gender = false;
	    // String.format(출력모양, 출력내용.......) 출력모양으로 만들어서 String으로 변환
	    System.out.println(String.format("[%s] - (%02d) - %s", name, age, (gender ? "남" : "여")));
	    
	    System.out.println(String.format("[{0}] - ({1}세) - {2}", name, age, (gender ? "남" : "여")));
	    
	    System.out.println(MessageFormat.format("{0}{0}{0} {0}{0}{0} {0}{0}{0}{0}{0}{0}{0}", "뽕"));
	}

}
