package kr.green.maven0628.generics;
// Generic 클래스 : 클래스 작성 시점에 타입이 결정되는 것이 아니라
//                  클래스를 사용 시점에 타입을 결정시키는 방법 JDK 1.5에 추가된 기능
//                  Generic Class 에서는 기본타입이 사용불가하다.

import java.util.Date;
import java.util.Vector;

public class GenericEx01 {

	public static void main(String[] args) {
		Vector v1 = new Vector(); // JDK 1.4 이전의 벡터 사용 : 타입에 안전하지 않다.
		// 아무 타입이나 다 들어간다. 백터의 타입은 최고 조상인 Object타입이다.
		v1.add(true);
		v1.add(11);
		v1.add(10.123);
		v1.add("김머현");
		v1.add(new Date());
		System.out.println(v1);
		// 꺼내서 사용할때 문제가 많이 발생한다. 들어간 타입을 알아야 형변환해서 사용
		System.out.println(!(boolean)v1.get(0));
		//System.out.println(!(boolean)v1.get(1)); // ClassCastException 발생. 정수를 boolean으로 형변환했기 때문
		
		
		// JDK 1.5 부터는
		Vector<Integer> v2 = new Vector<Integer>(); // 컴파일 시점에 타입을 지정해준다.
		// JDK 1.7부터 지원
		Vector<String> v3 = new Vector<>(); 
		
		v2.add(33);
		// v2.add(true); // 코드 작성시(컴파일 시점에서 타입의 유효성을 검증해준다.)
		for(int i = 0; i < 5; i++) v2.add((i+1)*10);
		System.out.println(v2);
		for(int i = 0; i < 5; i++) System.out.println("두배 : " + (v2.get(i)*2));
		
	}

}
