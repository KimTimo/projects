package kr.green;


interface ShowMessage{
	void viewMessage(String name);
}
class Message implements ShowMessage{
	@Override
	public void viewMessage(String name) {
		System.out.println("(" + name + ")");		
	}
}
class OuterClass{ // 외부 클래스
	int a;
	
	class InnerClass{ // 내부 클래스 : 이 클래스 안에서 사용
		void show(){
			System.out.println("A = " + a); // 외부 클래스의 멤버 마음대로 사용
		}
	}
	void show() {
		int x = 100;
		// 메소드 내의 클래스 : 메소드 내에서만 사용가능
		class LocalClass{
			void show() {
				System.out.println("x = " + x);
			}
		}
		new InnerClass().show(); // 내부클래스 사용
		new LocalClass().show(); // 로컬클래스 사용
	}
}

public class InnerClassEx {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		outerClass.show();
		
		OuterClass.InnerClass inObj = outerClass.new InnerClass();
		inObj.show();
		
		Message message = new Message();
		message.viewMessage("한사람");
		
		new Message().viewMessage("두사람");
		
		new ShowMessage() {
			@Override
			public void viewMessage(String name) {
				System.out.println("[" + name + "]");		
			}
		}.viewMessage("머현이");
		
		new ShowMessage() {
			@Override
			public void viewMessage(String name) {
				System.out.println("-=[" + name + "]=-");		
			}
		}.viewMessage("머현이");
	}

}
