package kr.green.bank;

public class BonusApp {
	public static void main(String[] args) {
		BonusAccount acc1 = new BonusAccount("1111", "김벌처", 100_0000);
		BonusAccount acc2 = new BonusAccount("2222", "안곤듀");
		
		System.out.println(acc1);
		System.out.println(acc2);
		
		acc1.deposit(100_0000);
		acc2.deposit(150_0000);
		
		System.out.println(acc1);
		System.out.println(acc2);
	}

}
