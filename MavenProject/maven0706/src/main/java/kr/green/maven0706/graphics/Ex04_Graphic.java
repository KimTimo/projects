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

public class Ex04_Graphic extends JPanel implements Runnable {
	int nx = 0, ny = 0, swx = 1, swy = 1, width, height;
	
	public Ex04_Graphic() {
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("공움직이기");
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Ex04_Graphic());
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		width = getWidth();
		height = getHeight();
		g.setColor(Color.RED);
		g.fillOval(nx, ny, 20, 20);
	}
	
	public void run() {
		while(true)	{
			nx += 5 * swx;
			ny += 5 * swy;
			if(nx < 0 || nx > width - 20) swx *= -1;
			if(nx < 0 || nx > height - 20) swy *= -1;
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
	
}