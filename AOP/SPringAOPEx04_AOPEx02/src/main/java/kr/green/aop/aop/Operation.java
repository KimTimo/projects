package kr.green.aop.aop;

public class Operation {
	public void msg() {
		System.out.println("msg method invoked\n");
	}

	public int m() {
		System.out.println("m method invoked\n");
		return 2;
	}

	public int k() {
		System.out.println("k method invoked\n");
		return 3;
	}

	public void display() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("display() is invoked\n");
	}

	public void validate(int age) throws Exception {
		if (age < 18) {
			throw new ArithmeticException("어린놈");
		} else {
			System.out.println("성인 인증 성공");
		}
	}
}