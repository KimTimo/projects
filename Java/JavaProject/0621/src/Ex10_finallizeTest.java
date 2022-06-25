class Person{
	String name;
	public Person() {
		this("모효니");
	}
	public Person(String name) {
		this.name = name;
		System.out.println(name + "님이 탄생했습니다.");
	}
	@Override // 자바의 소멸자
	protected void finalize() throws Throwable {
		System.out.println(name + "님이 뛰어가셨습니다.");
	}
}
public class Ex10_finallizeTest {
	public static void main(String[] args) {
		// 생성자는 사용자가 호출해야 되지만 소멸자는 자동으로 호출된다.
		Person kimc = new Person();
		Person ahnc = new Person("안곤듀임당");
		// 소멸자가 호출되지 않는다. 프로그램이 종료해도 아직 객체는 메모리에 남아있다.
		
		// 강제로 메모리에서 제거해주세요 라고 부탁해보자. 메모리 제거는 JVM의 가비지 컬렉터가 해준다.
		
		// 현재 사용하는 참조 변수가 아무것도 가리키지 않는다면 "모효니"와 "안곤듀임당"은 가비지 객체가 되어
		// ge()에 의해서 자동으로 소멸자가 호출된다.
		kimc = null; // 연결해제
		ahnc = null;
		System.gc(); // 빠른 시간 내에 메모리에서 필요없는 객체를 제거해 달라고 부탁하는 메서드

	}
}
