package kr.green.maven0707.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ex07_DrawImage	extends JFrame {
	public Ex07_DrawImage() {
		setTitle("로또 이미지 자르기");
		setSize(1000,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPenel()); // 이미지가 그려진 판넬을 윈도우에 붙이기
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex07_DrawImage();
	}
	
	class MyPenel extends JPanel{
		BufferedImage srcImg;  // 합쳐진 이미지
		BufferedImage img[] = new BufferedImage[45]; // 잘라서 저장할 변수
		int width, height; // 이미지 한장의 크기
		// 생성자에서 모든 이미지를 읽어서 넣자!!!
		public MyPenel() {
			// 원본이미지 읽기
			try {
				srcImg = ImageIO.read(new File("src/main/resources/lotto_ball_vert.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 저장할 1개의 이미지 크기
			width = srcImg.getWidth();
			height = srcImg.getHeight()/img.length;
			// 반복문을 돌려서 1개씩 잘라 배열에 저장해보자!!!!!
			for(int i=0;i<img.length;i++) {
				img[i] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = img[i].getGraphics();
				// 원본이미지에서 필요한 부분만 잘라서 만든이미지에 복사
				g.drawImage(srcImg, 0, 0, width, height, 0, i*height, width,(i+1)*height, this);
				// 잘라낸 이미지 저장
				try {
					ImageIO.write(img[i], "png", new File("src/main/resources/ball/ball_" +String.format("%02d",i+1) + ".png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 그려보자
		@Override
		public void paint(Graphics g) {
			// 원본 이미지를 출력해보자
			g.drawImage(srcImg, 0, 0, null);
		}
	}
}
