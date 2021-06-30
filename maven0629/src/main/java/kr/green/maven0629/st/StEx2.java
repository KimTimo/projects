package kr.green.maven0629.st;

import java.util.StringTokenizer;

public class StEx2 {

	public static void main(String[] args) {
		String str = "딸기(100원), 고구마(300원), 감자(700원), 당근(430원)";
		// 위의 데이터를
		// 딸기는 100원입니다.
		// 고구마는 300원입니다. 형식으로 출력하시오.
		
		for(String item : str.split(",")) {
			System.out.println(item.trim());
			System.out.println(item.trim().split("\\(")[0] + "는(은)" + item.trim().split("\\(")[1].replace(")","") + "입니다.");
		}
		
		System.out.println("----------------------------찐방지선-------------------------------");
		// 위의 문제를 StringTokenizer 를 이용해 풀어보자.
		StringTokenizer st = new StringTokenizer(str,", ");
		System.out.println(st.countTokens() + "개");
		while(st.hasMoreTokens()) {
			//System.out.println(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "()");
			String s1 = st2.nextToken();
			String s2 = st2.nextToken();
			System.out.println(s1 + "는(은) " + s2 + "입니다잇");
		}
		
	}

}
