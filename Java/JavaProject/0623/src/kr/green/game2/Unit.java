package kr.green.game2;

public abstract class Unit {
	int x;
	int y;
	abstract void move(int x, int y); // 이동
	protected void stop() {System.out.println(getClass().getSimpleName() + "멈춰"); } // 정지
}
