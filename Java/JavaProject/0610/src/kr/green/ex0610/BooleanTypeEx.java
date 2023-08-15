package kr.green.ex0610;

public class BooleanTypeEx {

	public static void main(String[] args) {

		boolean gender = true;
		System.out.println("성별 : " + gender);
		System.out.println("성별 : " + (gender ? "남자":"여자"));
		// 3항 연산사 : 연산 대상이 3개인 연산자
		// 값 ? 참 : 거짓
		// ! : NOT연산자
		System.out.println("성별 : " + (!gender ? "남자":"여자"));
		
		gender = !gender;
		System.out.println("성별 : " + (gender ? "남자":"여자"));
	}

}
