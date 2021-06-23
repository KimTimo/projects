package kr.green.bank;

public class CheckingApp {
	public static void main(String[] args) {
		CheckingAccount acc1 = new CheckingAccount("1111", "김머현", 100_000, "111-1234");
		CheckingAccount acc2 = new CheckingAccount("2222", "안곤듀", 200_000, "111-1235");
	
	System.out.println(acc1);
	System.out.println(acc2);
	
	
	try {
		acc2.deposit(acc1.withdraw(50_0000)); // 통장에서 이체
		acc2.deposit(acc1.pay("111-1234", 20_0000)); // 카드로 찾아서 이체
		// 에러 검사
		acc2.deposit(acc1.pay("111-1234", 40_0000)); // 잔액부족
		acc2.deposit(acc1.pay("111-1233", 40_0000)); // 카드번호가 다른경우
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	System.out.println(acc1);
	System.out.println(acc2);
	
	}
}
