package kr.green.maven0702.thread6;

// 계좌를 이체하는 스레드
public class TransferThread extends Thread {
	SharedArea1 sharedArea; // 계좌정보

	TransferThread(SharedArea1 area) {
		sharedArea = area;
	}
	/*
	 * critical section 의 동기화
	 * 예기치 못한 순간에 다른 스레드로 제어가 넘어가서 예상치 못한 문제가 발생할 수 있다.
	 * 이런 문제는 주로 공유 데이터를 사용하는 부분에서 일어나는데, 이런 부분을 critical section 이라고 한다.
	 */

	public void run() {
		// 12번 이체
		for (int cnt = 0; cnt < 12; cnt++) {
            // critical section의 동기화 : 작업전환이 이루어지면 안되는 critical section 을 불록으로 잡아준다.
			//                             블록 내에서는 작업전환이 이루어지지 않는다.
			synchronized (sharedArea) {
				// 계좌 이체 기능을 수행하는 클래스
				sharedArea.account1.widthdraw(1000000);
				System.out.print("이몽룡 계좌 : 100만원 인출,");
				sharedArea.account2.deposit(1000000);
				System.out.println("성춘향 계좌 : 100만원 입금");
			}
		}
	}
}
