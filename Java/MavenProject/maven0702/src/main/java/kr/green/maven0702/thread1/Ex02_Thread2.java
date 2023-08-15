package kr.green.maven0702.thread1;

public class Ex02_Thread2 {
	public static void main(String[] args) {
		// 멀티 스레드
		
		// 새로운 스레드를 시작!!!!
		AlphaThread thread = new AlphaThread();
		thread.start();
		
		for(int i=1;i<=26;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// Thread를 상속받아 스레드 클래스 만들기
	static class AlphaThread extends Thread{
		// run()메서드를 오버라이딩 한다.
		@Override
		public void run() {
			for(char i='A';i<='Z';i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
