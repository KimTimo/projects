package kr.green.vo;
// Human 클래스를 상속 받아 Student 클래스를 만든다.
public class Student extends Human {
	private String stuNum; // 필드 추가

	public Student() {
		this("무명", "210001");
	}

	public Student(String name, String stunum) {
		super(name); // 부모 생성자 호출 : 반드시 첫줄에 있어야 한다.
		//this.name = name;
		this.stuNum = stunum;
	}

	@Override // 기능 변경
	public String toString() {
		return super.toString() + "\n" + // 부모 메소드 호출
	"학번 : " + stuNum;
	}

	// 기능 변경 : 부모의 메소드를 재정의해서 사용한다.
	@Override   // @로 시작되는 것을 어노테이션이라 한다.
	            // 여기서는 컴파일러 보고 오버라이딩이다 라고 알리는 역할 담당
	public void think() {
		System.out.println("넘모 배부르군!");
	}

	// 기능 추가
	public void study() {
		System.out.println("Q평 W평 E평 R평");

	}

}
