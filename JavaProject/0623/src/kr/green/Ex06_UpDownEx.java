package kr.green;

// Up Casting : 자손의 타입을 부모 변수에 대입한다.
// Down Casting : 부모의 타입을 자손 변수에 대입한다.
class Car {
	String color;
	int door;

	void drive() {
		System.out.println("운전을 합니다. 부릉부릉!");
	}

	void stop() {
		System.out.println("멈춰!!!!!");
	}
}

class FireEngine extends Car {
	void drive() {
		System.out.println("운전을 합니다. 우우우우웅우웅~~~");
	}
	void water() {
		System.out.println("물을 뿌려라!!!");
	}
}

class Ambulance extends Car{
	void siren() {
		System.out.println("삐용삐용삐용삐용");
	}
	void drive() {
		System.out.println("운전을 합니다. 삐뽀삐뽀삐뽀삐뽀");
	}
}
public class Ex06_UpDownEx {
	public static void main(String[] args) {
		// 자신의 타입의 변수에 자신을 대입한다. 당연하쥬.
		Car car = new Car();
		FireEngine fireEngine = new FireEngine();
		Ambulance ambulance = new Ambulance();
		
		// UpCasting : 부모 변수에 자식 객체를 대입    : 가능
		Car car2 = new FireEngine(); // 가능
		// DownCasting : 자식 변수에 부모 객체를 대입  : 불가능
		// Ambulance ambulance2 = new Car(); 
		// Ambulance ambulance2 = (Ambulance)new Car();   // 캐스팅 해서는 대입이 가능!  -- 실행시 ClassCastException 예외 발생
		
		// 이럴때는 가능하다 왜냐하면 car2는 변수의 타입이 Car이지만 실제 가리키는 객체는 FireEngine이다.
		FireEngine fireEngine2 = (FireEngine)car2;
		fireEngine2.water();
		System.out.println("******************************************");
		
		// 이렇게 사용하려고 한다.
		// 다형성 : 하나의 기능이 경우에따라 다양하게 발현된다.
		//          하나의 변수에서 똑같은 메소드를 호출했는데 결과가 여러가지이다.
		//          1. 자식이나 부모가 동일한 메소드를 가지고 있어야 한다. -- drive()
		//          2. 모든 자식들은 부모의 메소드를 오버라이딩 해야한다. -- drive() 메소드가 Car, FireEngine, Ambulance
		//          3. 부모의 변수에 자식의 객체를 대입해서 메소드를 호출한다.
		Car car3 = new Car();
		car3.drive();         // 여기
		
		car3 = fireEngine;
		car3.drive();         // 여기 : 타입은 부모타입 이지만 가리키고 있는 자식의 메소드가 호출이 된다.
		
		car3 = ambulance;
		car3.drive();         // 여기
		
		System.out.println("******************************************");
		// 업캐스팅이 가능하기 때문에 하나의 부모 변수로 여러개의 자식 객체들을 통제가 가능하다.
		Car[] cars = {car, fireEngine, ambulance};
		for(Car c : cars)
			c.drive();
		
	}

}
