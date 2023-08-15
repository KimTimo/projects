package kr.green.bank;

public class MinusAccount extends Account{

	protected int minus;
	
	public MinusAccount(String accountNo, String ownerName, int balance) {
		super(accountNo, ownerName, balance);
		minus = (int)(balance * 0.1); // 정책에 따라 잔액의 10%를 마이너스 한도로 주자
	}

	public MinusAccount(String accountNo, String ownerName) {
		super(accountNo, ownerName);
		minus = 0;
	}

	public int getMinus() {
		return minus;
	}

	@Override
	public String toString() {
		return super.toString() + ", : 마이너스한도 : " + minus;
	}
	
	// 기능을 변경해보자
	@Override
	public int withdraw(int amount) throws Exception {
		if((balance + minus) < amount) // 잔액+마이너스 한도보다도 출금액이 크면 출금 불가
			throw new Exception("인출이 불가능합니다.");
		balance -= amount;
		return amount;
	}

	@Override
	public void deposit(int amount) { // 입금이 되면 마이너스 한도도 변경해야 한다.
		super.deposit(amount); // 입금
		minus = (int)(balance * 0.1); // 한도 변경 : 정책에 따라 잔액의 10%를 마니어느 한도로 주자 
	}

	
	
}
