package kr.green.vo;

public class Point3D extends Point {
	private int z;

	public Point3D(int x, int y, int z) {
		super(x, y); // 명시적으로 부모의 생성자를 호출하면 super()는 자동 삽입 안된다.
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	@Override
	void draw() {
		System.out.println("(" + getX() + "," + getY() + "," + z + ")에 점을 그립니다."); 
	}

	@Override
	public String toString() {
		// 이렇게 쓰면 에러. x,y가 부모의 것이지만 private이므로 사용 모담
//		return x + ", " + y + ", " + z;
		return super.getX() + ", " + super.getY() + ", " + z;
	}
	
	void move(int x, int y, int z) {
		setX(x);
		setY(y);
		setZ(z);
		draw();
	}

}
