package kr.green.game2;

public class Dropship extends Unit {
	void load() {} // 실어
	void unload() {} // 내려
	@Override
	void move(int x, int y) {
	   System.out.println(getClass().getSimpleName() + "을 스크류를 이용하여 (" + x + ", " + y + ")로 이동합니다.");
	}
}
