package kr.green.game;

public class Tank {
	int x,y; // 위치
	void move(int x, int y) {} // 이동
	void stop() {System.out.println(getClass().getSimpleName() + "멈춰"); } // 정지
	void changeMode() {} // 공격모드 변환
}
