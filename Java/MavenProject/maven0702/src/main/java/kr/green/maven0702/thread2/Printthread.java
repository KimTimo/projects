package kr.green.maven0702.thread2;
// 소비자 스레드 : 공유 영역에 만들어진 데이터를 사용하는 스레드
class Printthread extends Thread{
	SharedArea sharedArea;
	public void run(){
		// 출력
		System.out.println("원주율 :" + sharedArea.result);
}
}
