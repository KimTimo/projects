package kr.green.bank;
// Account 클래스를 상속받아 직불카드 기능을 추가해보자

public class CheckingAccount extends Account{
	// 카드 번호 추가
	protected String cardNo;
	// 생성자 추가

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		//super(accountNo, ownerName);
		//this.cardNo = cardNo;
		this(accountNo, ownerName, 0, cardNo);
	}

	// 카드번호는 읽기 전용으로 getter만 작성
	public String getCardNo() {
		return cardNo;
	}
	
	// 출력용
	@Override
	public String toString() {
		return super.toString() + "-" + cardNo;
	}
	// 새로운 기능을 추가하자
	// 카드로 출금하는 기능
	public int pay(String cardNo, int amount) throws Exception {
		if(!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("지불이 불가능합니다.");
		return withdraw(amount);
	}
	
	
	

}
