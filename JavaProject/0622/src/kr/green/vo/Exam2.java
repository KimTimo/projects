package kr.green.vo;

public class Exam2 {
	public static void main(String[] args) {
		Point p1 = new Point();
		System.out.println(p1);
		Point p2 = new Point(10,20);
		System.out.println(p2);
		
		System.out.println("---------------------------");
		
		Point3D p3 = new Point3D(1, 2, 3);
		System.out.println(p3);
		
		System.out.println(p3.getX());
		System.out.println(p3.getY());
		System.out.println(p3.getZ());
	}

}
