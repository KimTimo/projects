package kr.green.maven0706.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.green.maven0706.image.Ex02_ImageDraw.MyPanel;

@SuppressWarnings({ "serial", "unused" })
public class Ex03_ImageDraw extends JFrame {

	BufferedImage img = null; // 이미지 파일을 읽어서 저장할 변수
	BufferedImage bi[] = new BufferedImage[10]; // 임시 이미지 파일을 저장할 변수
	int width, height; // 이미지의 폭과 높이를 저장할 변수

	public Ex03_ImageDraw() {
		setTitle("이미지 그리기");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex03_ImageDraw();
	}

	class MyPanel extends JPanel {
		public MyPanel() {
			// 이미지읽기
			try {
				img = ImageIO.read(new File("src/main/resources/ship2_1.png"));
				// 이미지의 폭과 높이를 구하자
				width = img.getWidth();
				height = img.getHeight();

				bi[0] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
				Graphics g = bi[0].getGraphics();
				g.drawImage(img, 0, 0, width, height, 0, 0, width, height, Color.WHITE, this); 
				
				img = ImageIO.read(new File("src/main/resources/ship2_2.png"));
				bi[1] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			    g = bi[1].getGraphics();
			    g.drawImage(img, 0, 0, width, height, 0, 0, width, height, Color.WHITE, this); 
			    
			    img = ImageIO.read(new File("src/main/resources/ship2_3.png"));
				bi[2] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); 
			    g = bi[2].getGraphics();
			    g.drawImage(img, 0, 0, width, height, 0, 0, width, height, Color.WHITE, this); 
			    
			    img = ImageIO.read(new File("src/main/resources/ship2_4.png"));
				bi[3] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); 
			    g = bi[3].getGraphics();
			    g.drawImage(img, 0, 0, width, height, 0, 0, width, height, Color.WHITE, this); 
				
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void paint(Graphics g) {
			if (img != null) {
				g.drawImage(bi[0], 0, 0, null);
				g.drawImage(bi[1], width, 0, null);
				g.drawImage(bi[2], width*2, 0, null);
				g.drawImage(bi[3], width*3, 0, null);
			}
		}
	}
}
