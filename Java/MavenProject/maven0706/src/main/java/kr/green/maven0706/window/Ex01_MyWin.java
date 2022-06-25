package kr.green.maven0706.window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Ex01_MyWin extends JFrame {
	
	public Ex01_MyWin() {
		// 디자인 
		initUI();
	}
	
	private void initUI() {
		setTitle("메뉴와 상태바"); // 윈도우 제목지정
        setSize(new Dimension(700, 400)); // 크기지정
        setLocationRelativeTo(null);// 화면 중앙배치
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 종료지정
        
        //--------------------------------------------------------------
        // 아이콘을 지정해 보자
        ImageIcon icon = new ImageIcon("src/main/resources/win.png");
        setIconImage(icon.getImage());
        //--------------------------------------------------------------
        // 메뉴를 만들어 달아보자
        JMenuBar menuBar = new JMenuBar(); // 메뉴바
        JMenu fileMenu = new JMenu("File"); // 자식이있는 메뉴
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem  exitMenu = new JMenuItem("종료(Exit)", new ImageIcon("src/main/resources/s_s_win.png")); // 표시될 자식메뉴
        exitMenu.setMnemonic(KeyEvent.VK_X); // 바로가기키 지정
        exitMenu.setToolTipText("누르면 프로그램을 종료합니다."); // 툴팁지정
        exitMenu.addActionListener(e->System.exit(0)); // 이벤트 지정
        
        JMenuItem  newMenu = new JMenuItem("새파일(New)");
        newMenu.setMnemonic(KeyEvent.VK_N); // 바로가기키 지정
        newMenu.addActionListener(e->System.out.println("새파일 선택")); // 이벤트 지정
        
        JMenuItem  openMenu = new JMenuItem("열기(Open)", KeyEvent.VK_O);
        openMenu.addActionListener(e->System.out.println("열기 선택")); // 이벤트 지정
        
        JMenuItem  saveMenu = new JMenuItem("저장하기(Save)");
        saveMenu.setMnemonic(KeyEvent.VK_S); // 바로가기키 지정
        saveMenu.addActionListener(e->System.out.println("저장 선택")); // 이벤트 지정
        
        JMenu importMenu = new JMenu("배경색바꾸기");
        JMenuItem  import1 = new JMenuItem("빨간색");
        // 단축키지정
        import1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        import1.addActionListener(e->{
        	Container container = getContentPane();
        	container.setBackground(Color.RED);
        });
        JMenuItem  import2 = new JMenuItem("파란색");
        import2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
        import2.addActionListener(e->{
        	Container container = getContentPane();
        	container.setBackground(Color.BLUE);
        });
        JMenuItem  import3 = new JMenuItem("초록색");
        import3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
        import3.addActionListener(e->{
        	Container container = getContentPane();
        	container.setBackground(Color.GREEN);
        });
        importMenu.add(import1);
        importMenu.add(import2);
        importMenu.add(import3);
        
        fileMenu.add(newMenu); // 메뉴에 메뉴아이템추가
        fileMenu.add(openMenu); // 메뉴에 메뉴아이템추가
        fileMenu.add(saveMenu); // 메뉴에 메뉴아이템추가
        fileMenu.addSeparator(); // 구분선 추가
        fileMenu.add(importMenu); // 서브메뉴 추가
        fileMenu.addSeparator(); // 구분선 추가
        fileMenu.add(exitMenu); // 메뉴에 메뉴아이템추가
        
        menuBar.add(fileMenu);  // 메뉴를 메뉴바에 추가
        setJMenuBar(menuBar);   // 윈도우에 메뉴 추가
        //--------------------------------------------------------------
        setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new Ex01_MyWin();
		});
	}
}
