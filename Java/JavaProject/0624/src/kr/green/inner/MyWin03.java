package kr.green.inner;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWin03 extends JFrame{ // JFrame : 윈도우 껍데기를 만들어주는 클래스
	public MyWin03() {
		this("이름없는 윈도우");
	}
	public MyWin03(String title) {
		super(title); // 윈도우 제목지정
		setSize(600, 400); // 윈도우 크기 지정
		setLocationRelativeTo(null); // 윈두우를 괄호안의 객체  중앙에 배치해라. null이면 화면 정중앙

		// 2. 윈도우 종료 지정을 익명 내부 클래스로 만든경우
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0); // 프로그램 강제종료
			}
		});
		// 배치 관리자를 지정
		setLayout(new FlowLayout());

		// 버튼을 눌러서 추가해보자
		JButton button = new JButton("눌러줘");
		// 버튼에 기능을 추가해보자!!
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("눌렀냐!!! 아프다~~~");
			}
		});
		
		// 버튼을 윈도우에 추가
		add(button);
		

		// 버튼을 눌러서 추가해보자
		JButton button2 = new JButton("눌러줘2");
		// 버튼에 기능을 추가해보자!!
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button2, "왜눌러 아프잖아!!!");
			}
		});
		
		// 버튼을 윈도우에 추가
		add(button2);

		setVisible(true); // 보여주세요
	}
	
	public static void main(String[] args) {
		new MyWin03("내가 만든 윈도우2"); // 윈도우 생성!!!! ---- 이렇게 하면 윈도우를 닫아도 프로그램은 끝나지 않는다.
	}
	
	/*
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
	*/
}
