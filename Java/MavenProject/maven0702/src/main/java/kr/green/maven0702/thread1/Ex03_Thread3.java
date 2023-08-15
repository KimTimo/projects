package kr.green.maven0702.thread1;

public class Ex03_Thread3 {
	public static void main(String[] args) {
		// 멀티 스레드
		
		// 새로운 스레드를 시작!!!!
		AlphaThread alphaThread = new AlphaThread();
		// Runnable인터페이스를 구현한 스레드는 스스로 실행하는 메서드가 없다.
		// 그래서 Thread클래스를 이용하여 시작해야 한다.
		Thread thread = new Thread(alphaThread); // Thread객체 생성시 Runnable인터페이스를 구현한 객체를 넘겨
		thread.start(); // Thread클래스의 start()메서드로 실행해야 한다.
		
		for(int i=1;i<=26;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// Runnable 인터페이스를 구현하여 스레드 클래스 만들기
	static class AlphaThread implements Runnable{
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
