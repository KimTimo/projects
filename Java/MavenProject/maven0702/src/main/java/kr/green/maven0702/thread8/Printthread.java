package kr.green.maven0702.thread8;

// 소비자 스레드 : 공유 영역에 만들어진 데이터를 사용하는 스레드
public class Printthread extends Thread {
	SharedArea sharedArea;

	public void run() {
		/*
		 * 절대로 종료될 수 없는 코드이다. 왜냐하면 이 코드에서는 isReady값이 변경되지 않고 외부에서 변경된다. 그래서 이런 경우에는
		 * 컴파일러가 코드를 자동으로 변경하지 못하도록 제한을 두어야 한다.
		 */
		/*
		 * while(sharedArea.isReady != true){ continue;
		 */
		
		// 잠시 대기 상태로 진입
		if(sharedArea.isReady != true) {
			try {
				synchronized (sharedArea) {
					sharedArea.wait();  // 대기 상태로 전환
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 계산이 완료된 후 출력
		System.out.println("\n원주율 :" + sharedArea.result);
	}
}
