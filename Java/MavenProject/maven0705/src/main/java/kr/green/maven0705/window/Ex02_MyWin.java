package kr.green.maven0705.window;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

public class Ex02_MyWin extends JFrame{
	
	public Ex02_MyWin() {
		// 디자인
		initUI();
	}
	
	private void initUI() {
		setTitle("Simple example");    // 윈도우 제목지정
		//setSize(300,200);  // 크기지정
		setSize(new Dimension(400,400)); // 크기지정
		setLocationRelativeTo(null);   // 화면 중앙배치
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료지정
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			// Ex02_MyWin win = new Ex02_MyWin();
			//win.setVisible(true);   // 보여주삼
			new Ex02_MyWin();
		});
	}
}
