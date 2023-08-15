package kr.green.maven0702.thread8;

public class ProgressThread extends Thread{
	@Override
	public void run() {
		System.out.println("계산중...");
		while(true) {
			System.out.println("..");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
