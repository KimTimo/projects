package kr.green.maven0706.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import lombok.Getter;

@SuppressWarnings("serial")
public class Ex02_Graphic extends JFrame {
	// 그래픽을 처리하기 위해서는 JPanel을 상속받고 paintComponent()메서드를 오버라이딩한다.
	// paintComponent()메서드는 윈도우의 무효화 영역이 생겼을때 자동으로 호출되는 메서드
	@Getter
	class MyPanel extends JPanel implements ActionListener {
		private final int DELAY = 150;
		private Timer timer; // 지정 시간마다 actionPerformed()메서드를 자동으로 호출해준다.

		public MyPanel() {
			timer = new Timer(DELAY, this); // 타이머 객체 생성(시간, ActionListener구현객체)
			timer.start(); // 타이머 시작
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 그리기 작업은 여기에서 한다.
			doDrawing(g);
		}

		// 그리기 작업
		private void doDrawing(Graphics g) {
			Graphics2D g2d = (Graphics2D) g; // 종이
			g2d.setPaint(Color.BLUE); // 펜
			int width = getWidth(); // 폭
			int height = getHeight(); // 높이
			Random random = new Random();
			for (int i = 0; i < 2000; i++) { // 1번 2000개씩 점을 찍었다.
				int x = random.nextInt(width / 2);
				int y = random.nextInt(height / 2);
				g2d.drawLine(x, y, x, y); // 좌측 상단 1/4
				g2d.drawLine(x + width / 2, y + height / 2, x + width / 2, y + height / 2); // 우측하단 1/4
				g2d.drawOval(x + width / 2, y, 10, 10); // 우측 상단 1/4
				g2d.drawOval(x, y + height / 2, 10, 10); // 좌측 하단 1/4
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint(); // 다시 그리기를 수행해라!!!
		}
	}

	public Ex02_Graphic() {
		setTitle("점찍기"); // 윈도우 제목지정
		setSize(new Dimension(700, 500)); // 크기지정
		setLocationRelativeTo(null);// 화면 중앙배치
		// setDefaultCloseOperation(EXIT_ON_CLOSE);// 종료지정
		MyPanel myPanel = new MyPanel();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				Timer timer = myPanel.getTimer();
				timer.stop();
			}
		});

		add(myPanel); // 그림이 그려지는 판넬을 프레임에 추가

		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex02_Graphic();
	}
}
