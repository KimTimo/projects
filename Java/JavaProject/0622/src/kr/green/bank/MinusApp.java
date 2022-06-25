package kr.green.bank;

public class MinusApp {
	public static void main(String[] args) {
		MinusAccount acc1 = new MinusAccount("1111", "김벌처", 100_0000);
		MinusAccount acc2 = new MinusAccount("2222", "안곤듀");
		
		System.out.println(acc1);
		System.out.println(acc2);
		
		try {
			acc2.deposit(acc1.withdraw(105_0000));
			System.out.println(acc1);
			System.out.println(acc2);
			acc2.deposit(acc1.withdraw(10_0000));
			System.out.println(acc1);
			System.out.println(acc2);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(acc1);
		System.out.println(acc2);
	}

}
