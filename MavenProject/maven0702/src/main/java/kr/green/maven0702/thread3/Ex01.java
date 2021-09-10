package kr.green.maven0702.thread3;

public class Ex01 {
	public static void main(String[] args) {
		SharedArea sharedArea = new SharedArea(); // 공유 영역 : 여기에 있는 데이터를 만들고 소비를 할거다
		
		// 생산자
		CalcThread thread1 = new CalcThread();
		thread1.sharedArea = sharedArea;

		// 소비자
		Printthread thread2 = new Printthread();
		thread2.sharedArea = sharedArea;
		

		// 프로그래스바를 보여주는 스레드
		ProgressThread thread3 = new ProgressThread();
		// 데몬스레드 : 다른 스레드가 모두 종료되면 자신도 스스로 종료되는 스레드
		// 데몬스레드로 지정한다. 반드시 스레드 시작전에 지정
		
		thread3.setDaemon(true);
		
		// 스레드 시작
		thread1.start();
		thread2.start();
		thread3.start();
		
		
	}
}
