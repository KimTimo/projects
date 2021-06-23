package kr.green.vo;

import java.util.Date;

public class Exam3 {
	public static void main(String[] args) {
		
		Date date = new Date(); // 동일한 이름의 클래스를 여러개 사용해야 한다면
		                        // 제일 많이 사용하는 클래스는 임포트하고 
		java.sql.Date date2;    // 사용 빈도가 조금 적은 클래스는 전체 경로로 사용하면 된다.
		
		com.zetcode.Date date3;
		
		
		
		Point p1 = new Point(10, 10);
		p1.draw();
		p1.move(20, 20);
		
		System.out.println("------------------------------------");
		
		Line line = new Line(10, 10, 100, 50);
		line.draw();
		line.move(30, 30);
		
		Circle circle = new Circle(40,40,50,70);
		circle.draw();
		circle.move(70, 70);
		System.out.println("------------------------------------");
		
		Ractangle ractangle = new Ractangle(10,10,80,90);
		ractangle.draw();
		ractangle.move(60, 30);
		
		
	}

}
