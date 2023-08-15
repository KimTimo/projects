package kr.green.maven0707.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ex08_DrawImage	extends JFrame {
	public Ex08_DrawImage() {
		setTitle("로또 이미지 합치기");
		setSize(1000,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPenel()); // 이미지가 그려진 판넬을 윈도우에 붙이기
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex08_DrawImage();
	}
	
	class MyPenel extends JPanel{
		BufferedImage img[] = new BufferedImage[46]; // 이미지 파일을 읽어서 저장할 변수
		BufferedImage saveImg;  // 합쳐서 저장할 이미지
		int width, height; // 이미지 한장의 크기
		// 생성자에서 모든 이미지를 읽어서 넣자!!!
		public MyPenel() {
			for(int i=0;i<img.length-1;i++) {
				try {
					img[i] = ImageIO.read(new File("src/main/resources/ball/ball_" + String.format("%02d",i+1) + ".png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			width = img[0].getWidth();
			height = img[0].getHeight();
			// 저장할 이미지를 만들자!!! : 폭*이미지개수
			saveImg =  new BufferedImage(width, height * img.length, BufferedImage.TYPE_INT_RGB);
			// 그래픽스 객체 얻기
		    Graphics g = saveImg.getGraphics();
			// 반복문을 돌면서 이지지를 저장이미지에 복사한다.
			for(int i=0;i<img.length-1;i++) {
			    g.drawImage(img[i], 0, i*height, width, (i+1)*height, 0, 0, width, height, Color.WHITE, this);
			}
			g.drawImage(img[0], 0, 45*height, width, 46*height, 0, 0, width, height, Color.WHITE, this);
			
			// 합쳐진 이미지를 파일로 저장해보자!!!!
			 try {
				ImageIO.write(saveImg, "jpg", new File("src/main/resources/lotto.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 그려보자
		@Override
		public void paint(Graphics g) {
			// 합쳐진 이미지를 출력해보자
			g.drawImage(saveImg, 0, 0, null);
		}
	}
}
