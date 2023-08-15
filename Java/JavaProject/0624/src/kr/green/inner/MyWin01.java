package kr.green.inner;

import javax.swing.JFrame;

public class MyWin01 extends JFrame{ // JFrame : 윈도우 껍데기를 만들어주는 클래스
	public MyWin01() {
		this("이름없는 윈도우");
	}
	public MyWin01(String title) {
		super(title); // 윈도우 제목지정
		setSize(600, 400); // 윈도우 크기 지정
		setLocationRelativeTo(null); // 윈두우를 괄호안의 객체  중앙에 배치해라. null이면 화면 정중앙

		// 1. 윈도우 종료 지정을 외부 클래스로 만든경우
		MyWindowListener listener = new MyWindowListener();
		addWindowListener(listener); 
		
		setVisible(true); // 보여주세요
	}
	
	public static void main(String[] args) {
		new MyWin01("내가 만든 윈도우"); // 윈도우 생성!!!! ---- 이렇게 하면 윈도우를 닫아도 프로그램은 끝나지 않는다.
	}
}
