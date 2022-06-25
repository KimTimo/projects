package kr.green.bank;

public class AccountApp {
	public static void main(String[] args) {
		Account acc1 = new Account("336-255-334412", "김벌처",300_0000);
		System.out.println(acc1);
		Account acc2 = new Account("336-255-334413", "안곤듀");
		System.out.println(acc2);
		
		try {
			// 곤듀한테 용똔
			int amount = acc1.withdraw(150_0000);
			acc2.deposit(amount);
			System.out.println(acc1);
			System.out.println(acc2);
			
			// 한번더
			amount = acc1.withdraw(200_0000);
			acc2.deposit(amount);
			System.out.println(acc1);
			System.out.println(acc2);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(acc1);
		System.out.println(acc2);
	}

}
