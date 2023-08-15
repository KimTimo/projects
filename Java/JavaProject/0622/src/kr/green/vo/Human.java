package kr.green.vo;

public class Human {
	// protected : 자식은 마음대로 접근해라~
	protected String name;

	public Human() {
		this("무명");
	}

	public Human(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름 : " + name;
	}

	public void think() {
		System.out.println("오점뭐!");
	}

}
