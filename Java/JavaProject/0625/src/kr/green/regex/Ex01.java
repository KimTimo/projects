package kr.green.regex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class Ex01 {
	public static void main(String[] args) {
		ex1();
		System.out.println("----------------------");
		ex2();
		System.out.println("----------------------");
		ex4();
	}

	static public void ex1() {
		// 문자열.matches(정규표현식) : 문자열이 정규포현식에 유효한지를 검사해서 true/false를 리턴
		
		String pattern = "ab.";   // . : 1글자를 대신한다.
		System.out.println("ab".matches(pattern));
		System.out.println("abc".matches(pattern));
		System.out.println("ab1".matches(pattern));
		
		pattern = "ab\\s\\S";  // \\s : 화이트스페이스 \\S : 화이트스페이스 아닌것
		                       // ab다음 1글자는 화이트스페이스이고 그 다음 글자는 화이트스페이스가 아닌것을 지정
		System.out.println("ab  ".matches(pattern));
		System.out.println("ab c".matches(pattern));
		System.out.println("ab	c".matches(pattern));
	}
	
	public static void ex2() {
		String result = "";
		result = "The cat sat on the mat.".replaceAll("[Tt]he", "*");  // [문자] : 또는 ==> The 또는 the 를 *로 치환
		System.out.println(result);
		
		result = "The cat sat on the mat.".replaceAll("^[Tt]he", "*");  // ^ : 지정문자열 시작하는 ==> The 또는 the 로 시작하는 문자 *로 치환
		System.out.println(result);
		
		result = "The cat sat on the mat. and the cat".replaceAll("cat", "*"); // cat을 *로 치환
	    System.out.println(result);

	    result = "The cat sat on the mat. and the cat".replaceAll("cat$", "*"); // cat으로 끝나는 것을 *로 치환
	    System.out.println(result);
	    
	    result = "This island is beautiful.".replaceAll("is", "*");
	    System.out.println(result);

	    result = "This island is beautiful.".replaceAll("\\bis\\b", "*");
	    System.out.println(result);
	}
	
	public static void ex4() {
	    String pattern = "[abc][vz]";
	    System.out.println("av".matches(pattern));
	    System.out.println("ac".matches(pattern));

	    pattern = "Ex_[a-g1-5]";
	    System.out.println("Ex_g".matches(pattern));
	    System.out.println("Ex_6".matches(pattern));
	}
}
