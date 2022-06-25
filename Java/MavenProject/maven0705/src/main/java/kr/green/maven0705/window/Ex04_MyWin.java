package kr.green.maven0705.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex04_MyWin extends JFrame{
	
	public Ex04_MyWin() {
		// 디자인
		initUI();
	}
	
	private void initUI() {
		setTitle("Simple example");    // 윈도우 제목지정
		//setSize(300,200);  // 크기지정
		setSize(new Dimension(400,400)); // 크기지정
		setLocationRelativeTo(null);   // 화면 중앙배치
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료지정
		
		// --------------------------------------------------
		// 아이콘을 지정해보자
		ImageIcon icon = new ImageIcon("src/main/resources/win.png");
		setIconImage(icon.getImage());
		// --------------------------------------------------
		// 버틀을 추가해보자
		JButton button = new JButton("종료(Q)");   // 디자인
		// 바로가기 키지정
		button.setMnemonic(KeyEvent.VK_Q);      // Alt + Q 로 바로가기 지정
		
		
		// 버튼에 툴팁을 지정해보자
		button.setToolTipText("클릭하면 윈도우가 종료됩니다.");
		
		button.addActionListener(e->{   // 람다식으로 버튼 이벤트 지정
			System.exit(0); // 강제종료
		});
		// 프레임에 추가
		// 레이아웃매니저 지정 : 컴포넌트들을 어떤식으로 배열할것인지를 지정
		//setLayout(new FlowLayout());
		//add(button);
		setLayout(new BorderLayout());
		add(button, BorderLayout.SOUTH);
		// --------------------------------------------------
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			// Ex02_MyWin win = new Ex02_MyWin();
			//win.setVisible(true);   // 보여주삼
			new Ex04_MyWin();
		});
	}
}
