package kr.green.graphic;
// 추상클래스는 객체는 생성할 수 없지만 변수가 부모로서 지위를 가지기 때문에 자식 통제가 가능하다. 다형성 구현에 사용된다.
abstract class Shape {
	final static double PI = 3.1415; // 변수도 가질 수 있고

	// void draw() {System.out.println("도형을 그린다."); } 내용이 있을 필요가 없기 때문에 추상메소드로 만든다.
	abstract void draw(); // 추상메소드
	void move() { // 일반 메소드도 가질 수 있다.
		System.out.println("지웁니다.");
	}
}

class Point extends Shape {
	void draw() {
		System.out.println("점을 그린다.");
	}
}

class Line extends Shape {
	void draw() {
		System.out.println("선을 그린다.");
	}
}

class Circle extends Shape { // 오버라이딩을 하지 않으면 에러가 발생한다.
	void show() {
		System.out.println("원을 그린다."); // 실수로 이름을 다르게 만드는 것을 방지가 가능하다.
	}

	@Override
	void draw() {
		System.out.println("원을 그린다.");
	}
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("사각형을 그린다.");
	}
}

public class GraphicEx {
	public static void main(String[] args) {
		Shape[] shapes = { new Rectangle(), new Line(), new Circle(), new Point() };
		for (int i = 0; i < shapes.length; i++) {
			shapes[i].draw();
			shapes[i].move();
		}
		
		// instanceof 연산자 : 대입이 가능한지 판단한다.
		// ----------------------------------------------
		System.out.println(shapes[1] instanceof Shape);    // true
		System.out.println(shapes[3] instanceof Circle);   // false
		System.out.println(shapes[0] instanceof Object);   // true : Object클래스는 자바의 최고 조상이므로 어디든 대입이 가능하다.

	}
}