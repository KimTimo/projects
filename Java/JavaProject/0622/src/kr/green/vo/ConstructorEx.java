package kr.green.vo;
// 상속시 생성자의 호출 순서
class Parent{
	public Parent() {
		System.out.println("부모의 생성자 호출");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("부모의 소멸자 호출");
	}
}

class Child extends Parent{
	public Child() {
		// 여기에 super()가 자동으로 추가되어 컴파일 된다.
		super(); // 부모 클래스의 기본 생성자가 없을 경우 이 부분에서 에러가 발생한다.
		          // 1. 부모클래스의 기본 생성자를 만들어 주거나
		          // 2. 부모생성자를 명시적으로 호출해주면 에러가 사라진다.
		System.out.println("자식의 생성자 호출");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("자식의 소멸자 호출");
		super.finalize();
	}
}

public class ConstructorEx {
	public static void main(String[] args) {
		Parent parent = new Parent();
		parent = null;
		System.gc();
		System.out.println("-------------------------------------------");
		Child child = new Child();
		child = null;
		System.gc();
		
	}

}
