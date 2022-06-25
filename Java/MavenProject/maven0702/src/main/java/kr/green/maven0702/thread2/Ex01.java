package kr.green.maven0702.thread2;

public class Ex01 {
	public static void main(String[] args) {
		SharedArea sharedArea = new SharedArea(); // 공유 영역 : 여기에 있는 데이터를 만들고 소비를 할거다
		
		// 생산자
		CalcThread thread1 = new CalcThread();
		thread1.sharedArea = sharedArea;

		// 소비자
		Printthread thread2 = new Printthread();
		thread2.sharedArea = sharedArea;
		
		// 두개의 스레드가 데이터를 공유한다.
		// 스레드 시작
		thread1.start();
		thread2.start();
		
		// 생산자가 계산을 완료하기 전에 소비자가 자원을 사용해 버린다. ==> 원주율 계산전에 출력이 이루어졌다.
		
		thread1.run(); // 일반 메소드 호출
		System.out.println("PI = " + sharedArea.result);
	}
}
