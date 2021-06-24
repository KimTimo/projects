package kr.green.lang;

class Person implements Cloneable{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	// 이 클래스를 가지고 깊은 복사를 많이 사용한다고 한다면 줄라 짜증난다.
	// 깊은 복사를 간단하게 clone() 메소드로 가능하게 해주면 편리하다.
	// clone() 메소드를 사용하려면 클래스에 2가지 작업을 해주어야 한다.
	// 1. Cloneable 인터페이스를 구현한다. 그런데 Cloneable 인터페이스는 표시인터페이스이다.
	// 2. clone()메소드를 오버라이딩 해줘야 한다.
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
	@Override
	public Person clone() {
		Person person = null;
		try {
			person = (Person)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return person;
	}
	
}

public class CloneEx {

	public static void main(String[] args) {
		Person person1 = new Person("한사람", 22);
		Person person2 = person1;  // 객체에 객체를 대입하면 주소가 복사된다. 얕은복사
		System.out.println(person1);
		System.out.println(person2);
		System.out.println();
		
		person2.age = 33;  // 1개만 수정해도
		System.out.println(person1);
		System.out.println(person2);  // 2개가 모두 변한다.
		System.out.println();
		
		// 내용을 복사하고 싶다. 깊은 복사
		// 1. 똑같은 객체를 한개 더 만들고
		// 2. 내용을 따로따로 복사해 주어야 한다.
		Person person3 = new Person("", 0);
		person3.name = person1.name;
		person3.age = person1.age;
		
		System.out.println(person1);
		System.out.println(person2);
		System.out.println();
		
		person3.age = 55;  // 1개만 수정
		System.out.println(person1);
		System.out.println(person3);  // 1개만 변한다.
		System.out.println();
		
		// clone()를 이용한 깊은 복사
//		try {
//			Person person4 = (Person) person1.clone();
//			person4.age = 44;
//			System.out.println(person1);
//			System.out.println(person4);
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		}
		Person person4 = person1.clone();
		person4.age = 44;
		System.out.println(person1);
		System.out.println(person4);
		
	}

}
