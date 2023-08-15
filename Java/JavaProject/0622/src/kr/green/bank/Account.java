package kr.green.bank;

public class Account { // 은행계좌 클래스
	protected String accountNo; // 계좌번호
	protected String ownerName; // 예금주
	protected int balance; // 잔액

	// 생성자
	public Account(String accountNo, String ownerName) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
	}

	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// getter & setter

	public String getAccountNo() {
		return accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public int getBalance() {
		return balance;
	}
	
	// 필요한 기능 오버라이딩

	@Override
	public String toString() {
		return accountNo + "(" + ownerName + ", " + balance + ")";
	}
	
	// 기능을 구현

	public int withdraw(int amount) throws Exception { // 출금하는 메서드
		if (balance < amount)
			throw new Exception("잔액이 부족합니다.");
		balance -= amount;
		return amount;
	}
	public void  deposit(int amount) { // 입금하는 메서드
		balance += amount;
	}

}