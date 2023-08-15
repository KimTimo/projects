package kr.green.maven0706.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Ex02_MyWin extends JFrame {

	public Ex02_MyWin() {
		// 디자인
		initUI();
	}

	private void initUI() {
		setTitle("메뉴와 상태바"); // 윈도우 제목지정
		setSize(new Dimension(700, 400)); // 크기지정
		setLocationRelativeTo(null);// 화면 중앙배치
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 종료지정

		// --------------------------------------------------------------
		// 아이콘을 지정해 보자
		ImageIcon icon = new ImageIcon("src/main/resources/win.png");
		setIconImage(icon.getImage());
		// --------------------------------------------------------------
		// 메뉴를 만들어 달아보자
		// 상태바를 만들어보자
		JLabel statusBar = new JLabel("Ready"); // 라벨 만들기
		statusBar.setBorder(BorderFactory.createEtchedBorder()); // 테두리 지정
		setLayout(new BorderLayout()); // 레이아웃매니저 지정 : BorderLayout(동서남북중앙에 배치)
		add(statusBar, BorderLayout.SOUTH); // 윈도우 하단에 표시

		JMenuBar menuBar = new JMenuBar(); // 메뉴바 만들기
		// 주메뉴 만들기
		// 파일메뉴 만들기
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		// View메뉴 만들기
		JMenu viewMenu = new JMenu("View");
		fileMenu.setMnemonic(KeyEvent.VK_V);
		menuBar.add(viewMenu);
		// 부메뉴 만들기
		JCheckBoxMenuItem showStatusBarMenuItem = new JCheckBoxMenuItem("Show statusbar");
		showStatusBarMenuItem.setMnemonic(KeyEvent.VK_S); // 바로가기 키
		showStatusBarMenuItem.setDisplayedMnemonicIndex(5);// s가 다섯번째 있는 s라고 지정
		showStatusBarMenuItem.setSelected(true); // 선택표시
		showStatusBarMenuItem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) { // 선택되면
					statusBar.setVisible(true); // 상태바 보이기
				} else {
					statusBar.setVisible(false); // 상태바 숨기기
				}
			}
		});
		viewMenu.add(showStatusBarMenuItem);

		// 배경색 바꾸기 메뉴 만들기
		JMenu backgroundColorMenu = new JMenu("배경색(B)");
		backgroundColorMenu.setMnemonic(KeyEvent.VK_B);
		// 레디오 버튼 메뉴
		ButtonGroup group = new ButtonGroup(); // 그룹만들고
		JRadioButton redItem = new JRadioButton("뻘건"); // 메뉴만들고
		redItem.setSelected(true); // 선택
		redItem.addItemListener(new ItemListener() { // 이벤트지정
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					getContentPane().setBackground(Color.red);
					statusBar.setText("뻘건색");
				}
			}
		});
		backgroundColorMenu.add(redItem); // 그룹에 추가

		JRadioButton greenItem = new JRadioButton("초록");
		redItem.setSelected(true);
		redItem.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					getContentPane().setBackground(Color.green);
					statusBar.setText("초록색");
				}
			}
		});
		backgroundColorMenu.add(greenItem);

		JRadioButton blueItem = new JRadioButton("퍼렁");
		redItem.setSelected(true);
		redItem.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					getContentPane().setBackground(Color.blue);
					statusBar.setText("퍼런색");
				}
			}
		});
		backgroundColorMenu.add(blueItem);

		group.add(redItem);
		group.add(greenItem);
		group.add(blueItem);

		menuBar.add(backgroundColorMenu);

		// Help 메뉴 : 오른쪽 끝으로 보내기
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);

		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(helpMenu);

		// --------------------------------------------------------------------------------------
		// 팝업메뉴 : 마우스 우클릭 했을때 나타나는 메뉴
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem maxMenuItem = new JMenuItem("최대화");
		maxMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
					setExtendedState(JFrame.MAXIMIZED_BOTH);
					maxMenuItem.setEnabled(false);
				}
			}
		});
		popupMenu.add(maxMenuItem);

		JMenuItem quitMenuItem = new JMenuItem("종료");
		quitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		popupMenu.add(quitMenuItem);
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				if(getExtendedState() != JFrame.MAXIMIZED_BOTH) {
					maxMenuItem.setEnabled(true);
				}
				if(e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		// --------------------------------------------------------------------------------------
		setJMenuBar(menuBar);

		getContentPane().setBackground(Color.red);
		// --------------------------------------------------------------------------------------
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new Ex02_MyWin();
		});
	}
}
