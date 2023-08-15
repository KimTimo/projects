package kr.green.game;
// 1장의 카드를 저장하기 위한 클래스
public class CardVO {
	private int number; // 0~51까지의 숫자를 저장하기위한 변수
	
	// 모든 객체가 공유하는 데이터는 static으로 만든다
	private static final String kind[] = "♠♥◆♣".split(",");
	// 문자열.split(구분자) : 구분자로 분리하여 배열을 만들어 리턴한다.
	private static final String[] nums = "1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 ,J ,Q ,K".split(",");
	
	// 숫자 1개를 받아 카드를 초기화하는 생성자
	public CardVO(int number) {
		super();
		this.number = number;
	}
	// Getter & Setter
	public String getKind() { // 무늬를 알아내는 메소드
		return kind[number/13];
	}
	public String getNums() {
		return nums[number%13];
	}
	//필요한 메소드 오버라이딩
	@Override
	public String toString() {
		return getKind() + getNums();
	}
	

}
