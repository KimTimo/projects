package kr.green.vo;

public class TimeDTO {

	public int hour, minute, second;
	
	// 생성자 메소드 : 객체를 생성할때 호출되는 메소드
	// 1. 크래스 이름과 같다.
	// 2. 메소드이지만 리턴타입이 없다.
	// 3. 만들지 않으면 자바 컴파일러가 기본생성자를 자동으로 만들어준다.
	// 기본생성자란 인수가 없는 생성자이다.
	// 4. 하지만 사용자가 다른 생성자를 만들면 기본 생성자는 자동으로 생성되지 않는다.
	//    그래서 생성자를 만들때는 기본 생성자까지 같이 만들어 주면 좋다.
	// 5. 주로 필드들의 초기화 작업을 수행한다.
	// 6. 오버로딩이 가능하다.
	
	public TimeDTO() {
		// 기본 생성자
	}
	public TimeDTO(int hour, int minute, int second) {
		// 클래스에는 자기 자신을 나타내는 숨겨진 필드 this가 존재한다.
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// 오버라이딩 : 부모의 기능을 재정의해서 사용한다. 이때는 부모의 프로토타입과 반드시 일치해야 한다.
	// 
	@Override
	public String toString() {
		return hour + "시 " + minute + "분 " + second + "초";
	}
}
