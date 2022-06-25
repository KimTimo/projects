package kr.green.bank;

public class BonusAccount extends Account{
	protected int bonusPoint;

	public BonusAccount(String accountNo, String ownerName, int balance) {
		super(accountNo, ownerName, balance);
		bonusPoint = (int)(balance*0.001);
	}

	public BonusAccount(String accountNo, String ownerName) {
		super(accountNo, ownerName);
		bonusPoint = 0;
	

	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	@Override
	public void deposit(int amount) {
		super.deposit(amount);
		bonusPoint += (int)(amount*0.001);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 보너스포인트 : " + bonusPoint + "원";
	}
	
	

}
