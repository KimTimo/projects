package kr.green.maven0705.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Ex07_MyWin extends JFrame{
	
	public Ex07_MyWin() {
		// 디자인
		initUI();
	}
	
	private void initUI() {
		setTitle("메뉴와 상태바");    // 윈도우 제목지정
		//setSize(300,200);  // 크기지정
		setSize(new Dimension(400,400)); // 크기지정
		setLocationRelativeTo(null);   // 화면 중앙배치
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료지정
		
		// --------------------------------------------------
		// 아이콘을 지정해보자
		ImageIcon icon = new ImageIcon("src/main/resources/s_s_win.png");
		setIconImage(icon.getImage());
		// --------------------------------------------------
		// 메뉴를 만들어 달아보자
		JMenuBar menuBar = new JMenuBar();   // 메뉴바
		JMenu fileMenu = new JMenu("file");  // 자식이있는 메뉴
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem exitMenu = new JMenuItem("종료(Exit)", icon);  // 표시될 자식 메뉴
		exitMenu.setMnemonic(KeyEvent.VK_X);  // 바로가기 키지정
		exitMenu.setToolTipText("누르면 프로그램을 종료합니다.");  // 툴팁지정
		exitMenu.addActionListener(e->System.exit(0));  // 이벤트 지정
		
		
		JMenuItem openMenu = new JMenuItem("열기(Open)");  // 표시될 자식 메뉴
		exitMenu.setMnemonic(KeyEvent.VK_O);  // 바로가기 키지정
		exitMenu.addActionListener(e->System.out.println("열기 선택"));  // 이벤트 지정
		
		JMenuItem newMenu = new JMenuItem("새파일(New)");  // 표시될 자식 메뉴
		exitMenu.setMnemonic(KeyEvent.VK_N);  // 바로가기 키지정
		exitMenu.addActionListener(e->System.out.println("새파일 선택"));  // 이벤트 지정
		
		JMenuItem saveMenu = new JMenuItem("저장하기(Save)");  // 표시될 자식 메뉴
		exitMenu.setMnemonic(KeyEvent.VK_S);  // 바로가기 키지정
		exitMenu.addActionListener(e->System.out.println("저장 선택"));  // 이벤트 지정
		
		JMenu importMenu = new JMenu("배경색 바꾸기");
		JMenuItem import1 = new JMenuItem("빨간색", KeyEvent.VK_R);
		// 단축키 지정
		import1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		import1.addActionListener(e->{
			Container container = getContentPane();
			container.setBackground(Color.RED);
		});
		JMenuItem import2 = new JMenuItem("초록색", KeyEvent.VK_G);
		import2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		import2.addActionListener(e->{
			Container container = getContentPane();
			container.setBackground(Color.GREEN);
		});
		JMenuItem import3 = new JMenuItem("파란색", KeyEvent.VK_B);
		import3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		import3.addActionListener(e->{
			Container container = getContentPane();
			container.setBackground(Color.BLUE);
		});
		importMenu.add(import1);
		importMenu.add(import2);
		importMenu.add(import3);
		
		
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.addSeparator();
		fileMenu.add(importMenu);
		fileMenu.add(exitMenu); // 메뉴에 메뉴아이템 추가
		
		menuBar.add(fileMenu);  // 메뉴를 메뉴바에 추가
		setJMenuBar(menuBar);   // 윈도우에 메뉴 추가
		// ------------------------------------------------------------
		
		setVisible(true);	
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			// Ex02_MyWin win = new Ex02_MyWin();
			//win.setVisible(true);   // 보여주삼
			new Ex07_MyWin();
		});
	}
}
