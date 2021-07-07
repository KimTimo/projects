package kr.green.maven0706.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lombok.Getter;

@SuppressWarnings("serial")
public class Ex01_Graphic extends JFrame {
	// 그래픽을 처리하기 위해서는 JPanel을 상속받고 paintComponent()메서드를 오버라이딩한다.
	// paintComponent()메서드는 윈도우의 무효화 영역이 생겼을때 자동으로 호출되는 메서드
	@Getter
	class MyPanel extends JPanel implements ActionListener {
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
			// 선그리기
			// drawLine(x1,y1,x2,y2)
			g2d.drawLine(0, 0, width, height);
		
			g2d.setPaint(Color.RED); // 펜
			g2d.drawLine(width, 0, 0, height);

			g2d.setPaint(Color.GREEN); // 펜
			g2d.drawLine(width/2, 0, width/2, height);

			g2d.setPaint(Color.YELLOW); // 펜
			g2d.drawLine(0, height/2, width, height/2);
			
			g2d.setPaint(Color.black); // 펜
			g2d.drawString("정말 재미 없는 자바", width/2 - 50, height/2 - 5);
			
			
			float[] dash1 = {2f, 0f, 2f};
	        float[] dash2 = {1f, 1f, 1f};
	        float[] dash3 = {4f, 0f, 2f};
	        float[] dash4 = {4f, 4f, 1f};

	        g2d.drawLine(20, 40, 250, 40);

	        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);

	        BasicStroke bs2 = new BasicStroke(1, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);

	        BasicStroke bs3 = new BasicStroke(1, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);

	        BasicStroke bs4 = new BasicStroke(1, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);

	        g2d.setStroke(bs1);
	        g2d.drawLine(20, 80, 250, 80);

	        g2d.setStroke(bs2);
	        g2d.drawLine(20, 120, 250, 120);

	        g2d.setStroke(bs3);
	        g2d.drawLine(20, 160, 250, 160);

	        g2d.setStroke(bs4);
	        g2d.drawLine(20, 200, 250, 200);
	        
	        g2d.dispose();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint(); // 다시 그리기를 수행해라!!!
		}
	}

	public Ex01_Graphic() {
		setTitle("선 그리기"); // 윈도우 제목지정
		setSize(new Dimension(700, 500)); // 크기지정
		setLocationRelativeTo(null);// 화면 중앙배치
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 종료지정
		
		MyPanel myPanel = new MyPanel();
		add(myPanel); // 그림이 그려지는 판넬을 프레임에 추가

		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex01_Graphic();
	}
}
