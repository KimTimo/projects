package kr.green.regexp1;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class RegExpEx06_Pattern6 {
	public static void main(String[] args) {
		/*
		사용한 flags를 확인하고 싶다면, java.util.regex.Pattern.flags() 를 통해 확인할 수 있습니다. 
		참고로, 위의 mehtod는 public int flags() 으로 정의되어 있습니다.
		
		Parttern 플래그 값 사용(상수)
		Pattern.CANON_EQ : None표준화된 매칭 모드를 활성화합니다.
		Pattern.CASE_INSENSITIVE : 대소문자를 구분하지 않습니다. 
		Pattern.COMMENTS : 공백과 #으로 시작하는 주석이 무시됩니다. (라인의 끝까지).
		Pattern.MULTILINE : 수식 ‘^’ 는 라인의 시작과, ‘$’ 는 라인의 끝과 match 됩니다.
		Pattern.DOTALL : 수식 ‘.’과 모든 문자와 match 되고 ‘\n’ 도 match 에 포함됩니다.
		Pattern.UNICODE_CASE : 유니코드를 기준으로 대소문자 구분 없이 match 시킵니다.
		Pattert.UNIX_LINES : 수식 ‘.’ 과 ‘^’ 및 ‘$’의 match시에 한 라인의 끝을 의미하는 ‘\n’만 인식됩니다.		 
		*/
		
		Pattern pattern1 = Pattern.compile("\\S", Pattern.CASE_INSENSITIVE);
		// int java.util.regex.Pattern.flags()
		System.out.println("pattern6 flags : " + pattern1.flags());
		Pattern pattern2 = Pattern.compile("\\S", Pattern.UNICODE_CASE | Pattern.DOTALL);
		System.out.println("pattern7 flags : " + pattern2.flags());
		System.out.println();
		
		// Field 확인
		System.out.println("상수확인 하기");
		Field[] fields = pattern2.getClass().getDeclaredFields();
		for(Field field : fields) {
			if(field.toString().startsWith("public static final"))
				try {
					// 전체 형식
					// System.out.println(field);
					//                 이름                      값
					System.out.println(field.getName() + " : " + field.get(pattern2));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
		}

	}
}
