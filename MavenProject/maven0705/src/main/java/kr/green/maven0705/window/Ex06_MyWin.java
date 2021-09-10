package kr.green.maven0705.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex06_MyWin extends JFrame{
	
	public Ex06_MyWin() {
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
		// 라벨을 추가해보자
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// 마우스포인터 좌표 얻기
				int x = e.getX();
				int y = e.getY();
				String title = String.format("마우스 좌표 : (%3d, %3d)", x,y);
				setTitle(title);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {  // 드래그할때
				;
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			// Ex02_MyWin win = new Ex02_MyWin();
			//win.setVisible(true);   // 보여주삼
			new Ex06_MyWin();
		});
	}
}
