package kr.green.vo;

public class Circle extends Point {
	private int width, height; // 폭과 높이

	public Circle() {
		super();
	}

	public Circle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		System.out.println(toString() + "에 원그리기");
	}
	
	@Override
	public String toString() {
		return "(" + super.toString() + ") - (" + (getX() + width) + ", " + (getY() + height) + ")";
	}
	

}
