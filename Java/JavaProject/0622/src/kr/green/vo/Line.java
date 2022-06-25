package kr.green.vo;

public class Line extends Point {
	private int width, height; // 폭과 높이

	public Line() {
		super();
	}

	public Line(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		System.out.println(toString() + "에 선그리기");
	}
	
	@Override
	public String toString() {
		return "(" + super.toString() + ") - (" + (getX() + width) + ", " + (getY() + height) + ")";
	}
	

}
