package kr.green.vo;

// 클래스 : 연관성있는 데이터를 모아서 사용자 정의 자료형을 만든다.
//          어떠한 데이터 타입도 묶을 수 있다.
// VO(Value Object) : 단순하게 데이터만을 저장하기 위한 용도의 클래스
// DTO(Data Transfer Object) : 데이터를 저장하기 위한 용도의 클래스
public class PersonVO {
	
	public PersonVO() {
		
	}


	public PersonVO(String name) {
		//super();
		//this.name = name;
		this(name, 0, false); // 자신의 생성자를 호출한다
	}
	


	public PersonVO(String name, int age) {
		//super();
		//this.name = name;
		//this.gender = gender;
		this(name, age, false); // 자신의 생성자를 호출한다
	}


	public PersonVO(String name, boolean gender) {
		//super();
		//this.name = name;
		//this.gender = gender;
		this(name, 0 , gender);
	}


	public PersonVO(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	// 필드(속성, 멤버변수) : 상태정보(값)를 저장
	public String name;
	public int age;
	public boolean gender;

	
	// 메서드 : 기능을 담당
	public void viewPerson() {
		System.out.print(name + "(" + age + "세, ");
		System.out.println((gender ? "남" : "여") + ")");
	}


	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
