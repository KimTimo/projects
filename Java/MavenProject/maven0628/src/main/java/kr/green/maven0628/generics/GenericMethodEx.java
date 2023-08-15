package kr.green.maven0628.generics;

class Util{
	// 제네릭 메서드의 선언  
	// 다른 타입의 두개 데이터를 받아 앞의 데이터는 키로 사용하고 뒤의 데이터는 값으로 사용하는 경우를 생각해 보자!!!
	public static <K,V> void method(K key, V value){
		System.out.println(key + " : " + value);
		// System.out.println("key Type : " + key.getClass().getTypeName());
		// System.out.println("value Type : " + value.getClass().getTypeName());
		// System.out.println();
	}
	// 제네릭이 없다면 존재하는 모든 타입에 대하여 아래 메서드를 오버로딩 해줘야 한다.
	public static void method2(String key, int value){
		System.out.println(key + " : " + value);
	}
	public static void method2(int key, double value){
		System.out.println(key + " : " + value);
	}
	public static void method2(String key, boolean value){
		System.out.println(key + " : " + value);
	}
}

class Some{}

public class GenericMethodEx {
	public static void main(String[] args) {
		Util.method2("하하하하", 123);
		Util.method2(123, 123.45);
		Util.method2("하하하하", true);
	
		
		// 제네릭 메서드의 사용
		Util.<String, Integer>method("하하하하", 123);
		Util.<Integer, Double>method(123, 123.45);
		Util.<String, Boolean>method("하하하하", true);
		Util.method("하하하하", true); // 타입 추론
		Util.method("하하하하", new Some()); // 타입 추론
	}
}
