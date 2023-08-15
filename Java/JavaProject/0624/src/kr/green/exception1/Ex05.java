package kr.green.exception1;

import javax.management.RuntimeErrorException;

// Checked Exception : 반드시 예외처리를 해야되는 예외들.... Exception의 자식 클래스들
public class Ex05 {
	public static void main(String[] args) {
		// String name = null;
		String name = "김벌처";
		System.out.println("움하하하하하하");
		try {
			if (name == null)
				throw new Exception("내가 만든 예외");
			System.out.println("이히히히히히히히히");
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 에러메시지 출력
			e.printStackTrace(); // 에러 추적
		}
		try {
			show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// show2(); // UnChecked Exception
	}

	// 예외 미루기
	// 메소드명 뒤에 발생할 소지가 있는 예외들을 적는다.
	// 이 메소드를 호출하는 쪽에서 반드시 예외 처리를 해야 한다.
	public static void show() throws Exception {
		throw new Exception("예외미루기1");
	}
	public static void show2() throws Exception {
		throw new RuntimeException("예외미루기2");
	}
	public static void show3() throws Exception {
		try{
			throw new Exception("예외미루기1");
		}catch(Exception e) {
			throw new RuntimeException("예외포장하기"); // Checked Exception 을 UnChecked Exception으로 포장해서 다시 던진다.
			                                            // 나를 사용하는 곳에서는 try블록 선택적으로 할 수 있게 된다.
		}
	}

}
