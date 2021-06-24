package kr.green.graphic;

import java.util.ArrayList;
import java.util.List;

// 제품들
class Product{
	int price;
	int bonusPoint;
}
class TV extends Product{

}
class Computer extends Product{
	
}
class Audio extends Product{
	
}
class Printer extends Product{
	
}

class Buyer{
	int money = 10000;
	int bonusPoint = 0;
	// Product[] cart = new Product[100]; // 장바구니 : 배열로 하지 않고 리스트로 만든다.
	List<Product> cart = new ArrayList<Product>();
	
	// 장바구니 넣기
	void addCart(Product product) {
		System.out.println(product.getClass().getSimpleName() + "을 장바구니에 담았습니다.");
		cart.add(product);
	}
	// 장바구니 보기
	void viewCart() {
		System.out.println("장바구니 내용");
		for(Product p : cart) {
			System.out.println(p.getClass().getSimpleName());
		}
	}
	
	// 물건을 구매할 메서드
	// 아래 처럼 만들면 제품의 개수 만큼 메서드를 만들어야 한다. 
	// ---- 이럴때 매개변수의 다형성을 이용하면 메서드 1개로 해결이 가능하다. 
//	void buy(TV tv) {
//		System.out.println("TV 구매");
//		money -= tv.price;
//		bonusPoint += tv.bonusPoint;
//	}
//	void buy(Computer computer) {
//		System.out.println("computer 구매");
//		money -= computer.price;
//		bonusPoint += computer.bonusPoint;
//	}
//	void buy(Audio audio) {
//		System.out.println("audio 구매");
//		money -= audio.price;
//		bonusPoint += audio.bonusPoint;
//	}
	// 매개 변수를 모든 제품의 부모타입으로 만들면 어떤 제품이든 받을 수 있다.
	void buy(Product product) {
		System.out.println(product.getClass().getSimpleName() + "구매");
		money -= product.price;
		bonusPoint += product.bonusPoint;
	}
}
public class CartEx {
	public static void main(String[] args) {
		Buyer kimc = new Buyer();
		kimc.buy(new TV());
		kimc.buy(new Computer());
		kimc.buy(new Audio());
		kimc.buy(new Printer());
		
		kimc.addCart(new TV());
		kimc.addCart(new Computer());
		kimc.addCart(new Audio());
		
		kimc.viewCart();
	}
}
