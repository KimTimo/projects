package kr.green;
// 싱글톤패턴 : 프로그램 실행 중에 객체를 단 1개만 만들어서 계속 재사용 하도록 하는 방법 (MVC패턴 중 하나)

import java.util.Calendar;

public class Singleton {
	// 1. 자기 자신의 객체를 정적멤버로 가진다.
	private static Singleton instance = new Singleton();
	// 2. 밖에서 객체를 생성하지 못하도록 생성자를 private으로 만든다.
	private Singleton(){}
	// 3. 이미 만들어진 객체를 사용하도록 객체를 얻는 메소드를 정의한다.
	public static Singleton getInstance() {
		return instance;
	}
	//-----------------------------------------------------------------------
	// Calendar calendar = Calendar.getInstance();   --- 싱글톤으로 만들어짐

}
