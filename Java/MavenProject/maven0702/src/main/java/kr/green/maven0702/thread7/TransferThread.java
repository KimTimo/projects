package kr.green.maven0702.thread7;

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
            sharedArea.transfer();
			
		}
	}
}
