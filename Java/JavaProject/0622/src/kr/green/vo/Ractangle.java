package kr.green.vo;

public class Ractangle extends Point {
	private int width, height; // 폭과 높이

	public Ractangle() {
		super();
	}

	public Ractangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		System.out.println(toString() + "에 사각형그리기");
	}
	
	@Override
	public String toString() {
		return "(" + super.toString() + ") - (" + (getX() + width) + ", " + (getY() + height) + ")";
	}
	

}
