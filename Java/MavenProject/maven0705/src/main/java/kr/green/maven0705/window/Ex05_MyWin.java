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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex05_MyWin extends JFrame{
	
	public Ex05_MyWin() {
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
		Color[] stdCols = { Color.black, Color.blue, Color.cyan,
                Color.darkGray, Color.gray, Color.green, Color.lightGray,
                Color.magenta, Color.orange, Color.pink, Color.red,
                Color.white, Color.yellow };
		setLayout(new GridLayout(3,5,10,10));
		JButton[] colorBtn = new JButton[stdCols.length];
		for(int i = 0; i < stdCols.length; i++) {
			final Color color = stdCols[i];
			colorBtn[i] = new JButton(String.format("버튼 %02",i+1));  // 라벨을 만들고
			colorBtn[i].setBackground(stdCols[i]);           // 배경색 지정하고
			colorBtn[i].addActionListener(e->{
				Container container = getContentPane();
				container.setBackground(color);
			});
			add(colorBtn[i]);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			// Ex02_MyWin win = new Ex02_MyWin();
			//win.setVisible(true);   // 보여주삼
			new Ex05_MyWin();
		});
	}
}
