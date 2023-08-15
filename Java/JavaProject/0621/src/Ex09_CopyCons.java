/*
 * 복사 생성자 : 자신의 타입을 받는 생성자
 */
class CopyCons {
	int data;

	public CopyCons() {
		// 기본 생성자
	}

	public CopyCons(CopyCons cons) {
		// 복사 생성자 : 인수로 자기 자신의 타입을 받는다.
		this.data = cons.data; // 여기에서 데이터를 하나하나 복사해준다.
	}

	// 소멸자 : 객체가 소멸시 자동으로 호출되는 메서드
	//          C/C++은 자원의 확보를 생성자에서 하고 소멸자에서 자원의 소멸을 담당
	//          Java는 객체의 소멸을 가비치컬렉터가 담당하기 때문에 만들 필요가 없다.
	//          하지만 소멸자가 존재는 한다. finalize() 메서드가 자바의 소멸자이다.
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}

public class Ex09_CopyCons {
	public static void main(String[] args) {
		CopyCons cons = new CopyCons();
		CopyCons cons2 = cons; // 객체에 객체를 대입 : 얕은 복사(주소가 복사된다.)

		cons2.data = 11; // 1개 변경
		System.out.println(cons.data);
		System.out.println(cons2.data); // 둘다 바뀜
		System.out.println();

		cons.data = 22; // 1개 변경
		System.out.println(cons.data);
		System.out.println(cons2.data); // 둘다 바뀜
		System.out.println();

		// 그렇다면 깊은 복사 (내용이 복사)는 어떻게 할까?
		// 1. 동일한 객체를 1개 더 만든다.
		CopyCons cons3 = new CopyCons();
		// 2. 내용을 따로따로 복사해야 한다.
		cons3.data = cons.data;

		System.out.println(cons.data);
		System.out.println(cons3.data); // 둘의 내용이 같다.
		System.out.println();

		cons3.data = 33;
		System.out.println(cons.data);
		System.out.println(cons3.data); // 둘의 내용이 다르다. 1개만 변경되었다.
		System.out.println();

		// 깊은 복사시 문제점 -> 필드가 많을 경우에는 값을 하나하나 복사해 주어야 한다. 쥿같다.
		// 깊은 복사를 해주는 좋은 방법이 없을까? 한가지로 복사 생성자를 이용하는 방법이 있다.
		CopyCons cons4 = new CopyCons(cons);// 복사 생성자를 호출하여 깊은 복사 수행
		System.out.println(cons.data);
		System.out.println(cons4.data);
		System.out.println();

		cons4.data = 99; // 1개 변경
		System.out.println(cons.data);
		System.out.println(cons4.data); // 둘의 내용이 다르다. 1개만 변경되었다. 둘은 서로 다른 객체다.

	}
}
