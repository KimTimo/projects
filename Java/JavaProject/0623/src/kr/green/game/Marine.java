package kr.green.game;

public class Marine {
	int x,y; // 위치
	void move(int x, int y) {} // 이동
	void stop() {System.out.println(getClass().getSimpleName() + "멈춰"); } // 정지
	void stimpack() {} // 스팀팩 사용
}
