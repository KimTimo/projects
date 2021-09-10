package kr.green.maven0702.thread8;

// 공유 영역 클래스 : 여러개의 스레드에서 접근할 자원
public class SharedArea {
	double result;
	boolean isReady; // 계산 완료 여부를 확인할 변수 선언
}
