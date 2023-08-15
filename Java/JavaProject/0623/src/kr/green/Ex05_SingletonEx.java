package kr.green;

public class Ex05_SingletonEx {
	public static void main(String[] args) {
		//Singleton singleton = new Singleton();    // 에러. 생성자가 private이라 외부에서 객체 생성 불가
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		Singleton singleton3 = Singleton.getInstance();
		// hashCode : JVM이 객체들을 구분하기 위해서 붙이는 일련번호. 해시코드가 같다면 같은 객체다!!!
		// 해시코드가 같다. 객체는 1개만 생기고 모든 변수가 공유된다.
		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());
		System.out.println(singleton3.hashCode());
		
		
		NonSingleton nonSingleton1 = new NonSingleton();
		NonSingleton nonSingleton2 = new NonSingleton();
		NonSingleton nonSingleton3 = new NonSingleton();
		// 해시코드가 다르다. 객체가 3개 생겼다.
		System.out.println(nonSingleton1.hashCode());
		System.out.println(nonSingleton2.hashCode());
		System.out.println(nonSingleton3.hashCode());
	}

}
