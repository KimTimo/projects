package kr.green.graphic;

class Parent{
	int x = 100;
	void show() {
		System.out.println("나는 부모입니다.");
	}
}
class Child extends Parent{
	int x = 999;
	void show() {
		System.out.println("나는 자슥입니다.");
	}
}
// 변수와 메소드가 겹칠 떄 어떻게 작동될까?
public class VarRefVar {
	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println(parent.x);
		parent.show();
		System.out.println("-----------------------------");
		
		Child child = new Child();
		System.out.println(child.x);
		child.show();
		System.out.println("-----------------------------");
		
		Parent p = new Child();
		System.out.println(p.x);  // 변수 타입이 우선 : Parent 의 x 출력
		p.show();                 // 객체 타입이 우선 : 자식의 메소드 호출
		System.out.println("-----------------------------");
		
	}

}
