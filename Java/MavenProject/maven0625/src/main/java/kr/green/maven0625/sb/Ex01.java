package kr.green.maven0625.sb;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ex01 {

	public static void main(String[] args) {
		String st = "하 호 히히히 ㅋㅋㅋㅋ    ";
		System.out.println(st.replace("\t", "   "));
		
		StringBuffer sb1 = new StringBuffer(st);
		System.out.println(sb1.toString().replace("\t", "   "));
		
		StringBuilder sb2 = new StringBuilder(st);
		System.out.println(sb2.toString().replace("\t", "   "));
		
		String str = "2345278690";
		// 문자열을 차례대로 정렬해보자.
		String[] strAr = str.split(""); // String 배열로 만들어주고
		System.out.println(Arrays.toString(strAr));
		Arrays.sort(strAr); // 정렬
		System.out.println(Arrays.toString(strAr));
		str = String.join("", strAr); // 문자열로 결합
		System.out.println(str);
		
		// 뒤집어서 String으로
		str = new StringBuffer(str).reverse().toString();
		System.out.println(str);
	}

}
