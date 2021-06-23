package kr.green.vo;

public class Point {
	private int x, y;
	public Point() {
		// super() 자동추가
	}

	public Point(int x, int y) {
		// super() 자동추가
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;

	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	void draw() {
		System.out.println("(" + x + "," + y + ")에 점을 그립니다.");
	}
	
	void move(int x, int y) {
		setX(x);
		setY(y);
		draw();
	}
	
	/*
	 * @Override public String toString() { return "(" + super.toString() + ") - ("
	 * + (getX() + width) + ", " + (getY() + height) + ")"; }
	 */

}
