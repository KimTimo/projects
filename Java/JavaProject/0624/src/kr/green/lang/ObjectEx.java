package kr.green.lang;

import java.lang.reflect.Method;

class Some{                    // 자바에서 클래스를 만들면 자동으로 Object 클래스를 상속받는다.

	@Override         // 자바의 소멸자. 사용자가 거의 작성하지 않는다. 객체가 소멸될때 자동으로 실행! 객체의 소멸 시점은 사용자가 알 수 없다.
	protected void finalize() throws Throwable {
		super.finalize();
	} 
	
}


public class ObjectEx {
	public static void main(String[] args) {
		Some some = new Some();
		// 그래서 11개의 메소드를 그냥 사용 가능하다.
		System.out.println(some.getClass());
		
		Class<? extends Some> classInfo = some.getClass(); // 클래스의 정보를 알고자할때
		System.out.println(classInfo);
		System.out.println(classInfo.getName());
		System.out.println(classInfo.getSimpleName());
		System.out.println(classInfo.getSuperclass());
		
		System.out.println();
		Method[] methods = classInfo.getMethods();
		System.out.println("메소드 목록");
		for(Method m : methods) {
			System.out.println(m.getName() + " : " + m.getParameterCount());
		}
	}

}
