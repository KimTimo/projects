package kr.blue;

import kr.green.Var;

/*
 * 접근 제어자
 * private   : 클래스 내부에서만 사용가능. 자식도 사용 불가    (정보의 은폐)
 * default   : 같은 패키지 내에서 사용가능. default는 쓰지 않는다.
 * protected : 다른 클래스에서는 자식만 사용가능  (정보의 은폐 순한맛)
 * public    : 어디서는 접근 가능
 */

class VarChild extends Var {
	public void show() {
		VarChild var = new VarChild();
		// System.out.println("private    : " + var.priVar); // 에러! 다른 클래스에서 사용 불가!!! 자식도 접근 못함
		// System.out.println("defVar     : " + var.defVar);    // 다른 패키지이기 때문에 에러 발생
		System.out.println("proVar     : " + var.proVar);    // 다른 패키지라도 자식은 접근이 가능하기 때문에 에러가 발생하지 않음.
		System.out.println("pubVar     : " + var.pubVar);    // 어디서든 접근가능
	}
}
class VarChild2{
	public void show() {
		Var var = new Var();
		// System.out.println("private    : " + priVar);     // 에러! 다른 클래스에서 사용 불가!!!
		// System.out.println("defVar     : " + var.defVar);    // 다른 패키지이기 때문에 에러 발생
		// System.out.println("proVar     : " + var.proVar);    // 다른 패키지 + 자식이 아니기 때문에 에러발생
		System.out.println("pubVar     : " + var.pubVar);    // 어디서든 접근가능
	}
}

public class Ex04_ModifierEx {

}
