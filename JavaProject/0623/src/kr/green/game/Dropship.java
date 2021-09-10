package kr.green.game;

public class Dropship {
	int x,y; // 위치
	void move(int x, int y) {} // 이동
	void stop() {System.out.println(getClass().getSimpleName() + "멈춰"); } // 정지
	void load() {} // 실어
	void unload() {} // 내려
}
