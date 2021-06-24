package kr.green.game2;

public class Tank  extends Unit {
	void changeMode() {} // 공격모드 변환

	@Override
	void move(int x, int y) {
	   System.out.println(getClass().getSimpleName() + "을 무한궤도를 이용하여 (" + x + ", " + y + ")로 이동합니다.");
	}
}
