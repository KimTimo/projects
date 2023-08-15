package kr.green.maven0706.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Ex03_Graphic extends JPanel implements ActionListener{
	int nx=0,ny=0,swx=1,swy=1, width, height; // nx :현재 x좌표, ny : 현재 y좌표
	Timer timer;
	public Ex03_Graphic() {
		Timer timer = new Timer(10, this);
		timer.start();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("공움직이기");
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Ex03_Graphic());
		frame.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		width = getWidth();
		height = getHeight();
		g.setColor(Color.RED);
		g.fillOval(nx, ny, 20, 20); // 원그리기
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 좌표 변경
		nx += 5 * swx; 
		ny += 5 * swy;
		if(nx<0 || nx>width-20) swx *= -1; // x축 경계에 도달하면 증가가 감소로 감소가 증가로 변경
		if(ny<0 || ny>height-20) swy *= -1;
		// 다시 그려라
		repaint();
	}
}
