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
public class Ex01_DrawImage extends JFrame{
	public Ex01_DrawImage() {
		setTitle("이미지 합치기");
		setSize(1000,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPenel());  // 이미지가 그려진 판넬을 윈도우에 붙이기
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex01_DrawImage();
	}
	
	class MyPenel extends JPanel{
		BufferedImage img[] = new BufferedImage[8];
		BufferedImage saveImg;
		String[] imageName = "ship2_1, ship2_2, ship2_3, ship2_4, ship2_hit_1, ship2_hit_2, ship2_hit_3, ship2_hit_4".split(",");
		int width, height;
		public MyPenel() {
			// 생성자에서 모든 이미지를 읽어서 넣자
			for(int i = 0; i < img.length; i++) {
				try{
					img[i] = ImageIO.read(new File("src/main/resources/" + imageName[i].trim() + ".png"));
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			width = img[0].getWidth();
			height = img[0].getHeight();
			// 저장할 이미지를 만들자 : 폭 * 이미지갯수
			saveImg = new BufferedImage(width * img.length, height, BufferedImage.TYPE_INT_RGB);
			// 그래픽스 객체 얻기
		    Graphics g = saveImg.getGraphics();
			// 반복문을 돌면서 이미지를 저장이미지에 복사한다.
			for(int i = 0; i < img.length; i++) {
				// 원본이미지에서 잘라서 그리기
				//         (원본, 대상자료4개, 원본좌표4개 배경색, 이미지옵저버)
			    g.drawImage(img[i], i*width, 0, (i+1)*width, height, 0, 0, width, height, Color.WHITE, this); // 원본을 그대로 복사
			}
			// 합쳐진 이미지를 파일로 저장해보자
			try {
				ImageIO.write(saveImg, "jpg", new File("src/main/resources/ship.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 그려보자
		@Override
		public void paint(Graphics g) {
			for(int i = 0; i < img.length; i++) {
				// 원본이미지들을 옆으로 붙여서 출력해보자
			    g.drawImage(img[i], i*width, 0, (i+1)*width, height, 0, 0, width, height, Color.WHITE, this); // 원본을 그대로 복사
			}
			// 합쳐진 이미지를 출력해보자
			g.drawImage(saveImg, 0, height, null);
		}
	}
}
