package kr.green.maven0702.thread7;

public class PrintThread1 extends Thread {
	SharedArea1 sharedArea; // 계좌정보

	PrintThread1(SharedArea1 area) {
		sharedArea = area;
	}

	public void run() {
		// 전체 계좌의 합계를 구한다..... 3번
		for (int cnt = 0; cnt < 3; cnt++) {
			System.out.println("계좌 잔액 합계 : " + sharedArea.getTotal());
		}
		try {
			Thread.sleep(1); // 잠시 대기
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
