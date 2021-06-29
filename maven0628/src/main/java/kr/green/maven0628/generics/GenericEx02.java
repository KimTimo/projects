package kr.green.maven0628.generics;
// 어떤 타입이든 모두 사용가능하게 하려면 Object로 만들어 사용했었다.
class OBox {
	Object item; // 1.4 이전은 멤버의 타입을 Object로 만들어 사용
	public OBox() {
		
	}
	
	public OBox(Object item) {
		this.item = item;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public void viewType() {
		System.out.println(item.getClass().getTypeName());
	}
}

public class GenericEx02 {
	public static void main(String[] args) {
		OBox box1 = new OBox("한사람");
		OBox box2 = new OBox(123);
		OBox box3 = new OBox(true);
		box1.viewType();
		box2.viewType();
		box3.viewType();
		System.out.println((String)box1.getItem() + 1);
		System.out.println((Integer)box2.getItem() + 1);
	}

}
