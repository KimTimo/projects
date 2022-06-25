package kr.green.maven0702.thread5;

// 계좌를 이체하는 스레드
public class TransferThread extends Thread {
	SharedArea1 sharedArea; //  계좌정보

	TransferThread(SharedArea1 area) {
		sharedArea = area;
	}

	public void run() {
		// 12번 이체
		for (int cnt = 0; cnt < 12; cnt++) {
			// 계좌 이체 기능을 수행하는 클래스
			sharedArea.account1.widthdraw(1000000);
			System.out.print("이몽룡 계좌 : 100만원 인출,");
			sharedArea.account2.deposit(1000000);
			System.out.println("성춘향 계좌 : 100만원 입금");
		}
	}
}
