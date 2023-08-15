package kr.green.inner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyWin02 extends JFrame{ // JFrame : 윈도우 껍데기를 만들어주는 클래스
	public MyWin02() {
		this("이름없는 윈도우");
	}
	public MyWin02(String title) {
		super(title); // 윈도우 제목지정
		setSize(600, 400); // 윈도우 크기 지정
		setLocationRelativeTo(null); // 윈두우를 괄호안의 객체  중앙에 배치해라. null이면 화면 정중앙

		// 2. 윈도우 종료 지정을 내부 클래스로 만든경우
		// MyWindowListener2 listener = new MyWindowListener2();
		// addWindowListener(listener); 
		// 위의 두줄은 1줄오 줄이면 : listener라는 변수는 1회용이다.
		addWindowListener(new MyWindowListener2());
		
		setVisible(true); // 보여주세요
	}
	
	public static void main(String[] args) {
		new MyWin02("내가 만든 윈도우2"); // 윈도우 생성!!!! ---- 이렇게 하면 윈도우를 닫아도 프로그램은 끝나지 않는다.
	}
	
	// 윈도우를 종료하는 코드를 내부 클래스로 정의
	// 이 클래스는 단 한번만 사용된다. 그렇다면 별도로 이렇게 클래스를 만들 필요가 있을까? 
	// 이럴때는 이름없는 클래스를 만들어서 사용하느 것이 더 간단하다.
	class MyWindowListener2  extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			System.exit(0); // 프로그램 강제종료
		}

	}
}
