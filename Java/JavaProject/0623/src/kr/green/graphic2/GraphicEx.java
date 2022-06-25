package kr.green.graphic2;

// 인터페이스는 객체는 생성할 수 없지만 변수가 부모로서의 지위를 가지므로 자식을 통제가 가능하다. 다형성 구현에 사용된다.
// 상수와 추상메서드 만으로 구성된 클래스를 class대신 interface라고 선언해서 사용한다.
interface Shape {
	double PI = 3.1415; // 변수도 가질수 있고. 자동으로 앞에 final static이 삽입된다.
	void draw(); // 추상 메서드. 자동으로 앞에 public abstract가 삽입된다.
}

interface Graphic1 {
	void erase();
}

interface Graphic2 {
	void resize();
}

// 인터페이스는 인터페이스끼리 다중 상속하다. 상속이므로 extends사용한다.
interface Graphic extends Graphic1, Graphic2{
	void rotate();
}

class Coord {
	int x, y;
	void move() { // 일반 메서드도 가질 수 있다.
		System.out.println("이동합니다.");
	}
}

// 인터페이스는 상속이라고 안하고 "구현"한다라고 한다. implements 사용한다.
// 다중 상속의 이점을 취할 수 있다.
// 인터페이스는 콤마로 구분하여 다중 구현이 가능하다.
class Point extends Coord implements Shape, Graphic {
	public void draw() {
		System.out.println("점을 그린다.");
	}
	@Override
	public void erase() {
		System.out.println("점을 지운다.");
	}
	@Override
	public void resize() {
		System.out.println("크기변경");
	}
	@Override
	public void rotate() {
		System.out.println("회전");
	}
}

class Line extends Coord implements Shape {
	public void draw() {
		System.out.println("선을 그린다.");
	}
}

class Circle extends Coord implements Shape { // 오버라이딩을 하지 않으면 에러가 발생한다.
	void show() {
		System.out.println("원을 그린다.");
	} // 실수로 이름을 다르게 만드는 것을 방지가 가능하다.

	@Override
	public void draw() { // 반드시 동일한 메서드를 오버라이딩 하라는 규칙이 생성된다. 실수를 방지 할 수 있다.
		System.out.println("원을 그린다.");
	}
}

class Rectangle extends Coord implements Shape {
	public void draw() {
		System.out.println("사각형을 그린다.");
	}
}

public class GraphicEx {
	public static void main(String[] args) {
		Shape[] shapes = { new Rectangle(), new Line(), new Circle(), new Point() };
		for (int i = 0; i < shapes.length; i++) {
			shapes[i].draw();
			((Coord) shapes[i]).move();
		}
	}
}
