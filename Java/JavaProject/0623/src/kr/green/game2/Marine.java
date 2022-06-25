package kr.green.game2;

public class Marine  extends Unit {
	void stimpack() {} // 스팀팩 사용

	@Override
	void move(int x, int y) {
	   System.out.println(getClass().getSimpleName() + "을 두발을 이용하여 (" + x + ", " + y + ")로 이동합니다.");
	}
}
