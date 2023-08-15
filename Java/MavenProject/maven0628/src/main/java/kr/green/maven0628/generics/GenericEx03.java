package kr.green.maven0628.generics;
// 어떤 타입이든 모두 사용가능하게 하려면 Object로 만들어 사용했었다.
class GBox<T> { // 선언시 <>fmf tkdydgksek.
	T item; // 1.4 이전은 멤버의 타입을 Object로 만들어 사용
	public GBox(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public void viewType() {
		System.out.println(getItem().getClass().getTypeName());
	}
}

public class GenericEx03 {
	public static void main(String[] args) {
		GBox<Integer> box1 = new GBox<>(123);
		GBox<String> box2 = new GBox<>("김벌처");
		GBox<Boolean> box3 = new GBox<>(true);
		
		box1.viewType();
		box2.viewType();
		box3.viewType();
		
		System.out.println(box1.getItem() + 1);
		System.out.println(box2.getItem() + 1);
	}

}
