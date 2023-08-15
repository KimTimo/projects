package kr.green.maven0701.io;

import java.io.Serializable;

// Serializable 인터페이스를 구현할때는 
// 반드시 serialVersionUID까지 같이 만들어 줘라!!!!
// Serializable 인터페이스는 표시 인터페이스로 구현해줄 메서드는 없다!!!!
public class Data2  implements Serializable{

	private static final long serialVersionUID = 6791997237922534048L;
	// 아래 2개 변수는 저장되고
	String name;
	int age;
	// 아래 2개 변수는 저장되지 않는다.
	static int MAX = 1024; 
	transient double pi = 3.14;
	
	// getter와 setter만 추가한다......
	// 그렇다면 저장 내용에는 변화가 있을까? 없다!!!!
	// 내용에는 변화가 없는데도 이전에 저장한 데이터는 읽을 수 없다.
	// 자바는 클래스를 만들면 각각의 클래스에 유일한 버전 번호를 부여한다.
	// 수정시마다 새로운 버전 번호를 부여한다.
	// 내용에 변화가 없어도 버전 번호가 다르면 다른 객체를 인식을 한다.
	// 수정해도 버전 번호를 일치 시킬 수 있다면 일기가 가능해진다. 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	// 단연히 메서드는 모든 객체가 공유하므로 저장되지 않는다.
	public Data2() {
		
	}
	public Data2(String name, int age) {
		this.name=name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name + "(" + age + "세)";
	}
}
