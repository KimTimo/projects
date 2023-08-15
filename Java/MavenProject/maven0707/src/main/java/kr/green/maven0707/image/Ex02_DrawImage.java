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
public class Ex02_DrawImage extends JFrame {
	public Ex02_DrawImage() {
		setTitle("이미지 자르기");
		setSize(1000, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPenel()); // 이미지가 그려진 판넬을 윈도우에 붙이기
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex02_DrawImage();
	}

	class MyPenel extends JPanel {
		BufferedImage srcImg; // 합쳐진 이미지
		BufferedImage img[] = new BufferedImage[8]; // 잘라서 저장할 변수
		String[] imageName = "ship2_1, ship2_2, ship2_3, ship2_4, ship2_hit_1, ship2_hit_2, ship2_hit_3, ship2_hit_4"
				.split(",");
		int width, height;

		public MyPenel() {
			try {
				srcImg = ImageIO.read(new File("src/main/resources/ship.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 저장할 1개의 이미지 크기
			width = srcImg.getWidth() / img.length;
			height = srcImg.getHeight();
			// 반복문을 돌려서 1개씩 잘라 배열에 저장해보자
			for (int i = 0; i < img.length; i++) {
				img[i] = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
				Graphics g = img[i].getGraphics();
				// 원본이미지에서 필요한 부분만 잘라서 만든이미지에 복사
				g.drawImage(srcImg, 0, 0, width, height, i * width, 0, (i + 1) * width, height, this);
				// 잘라낸 이미지 저장
				try {
					ImageIO.write(img[i], "png", new File("src/main/resources/ship_" +(i+1) + ".png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 그려보자
		@Override
		public void paint(Graphics g) {
			for (int i = 0; i < img.length; i++) {
				// 원본이미지들을 옆으로 붙여서 출력해보자
				g.drawImage(img[i], i * width, 0, (i + 1) * width, height, 0, 0, width, height, Color.WHITE, this); // 원본을
																													// 그대로
																													// 복사
			}
			// 합쳐진 이미지를 출력해보자
			g.drawImage(srcImg, 0, height, null);
		}
	}
}
