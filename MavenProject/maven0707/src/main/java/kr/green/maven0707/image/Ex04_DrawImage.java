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
public class Ex04_DrawImage extends JFrame {
	public Ex04_DrawImage() {
		setTitle("이미지 자르기");
		setSize(1000, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPenel()); // 이미지가 그려진 판넬을 윈도우에 붙이기
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex04_DrawImage();
	}

	class MyPenel extends JPanel {
		BufferedImage srcImg; // 합쳐진 이미지
		BufferedImage img[] = new BufferedImage[65]; // 잘라서 저장할 변수
		String[] imageName = "ship2_1, ship2_2, ship2_3, ship2_4, ship2_hit_1, ship2_hit_2, ship2_hit_3, ship2_hit_4"
				.split(",");
		int width, height;

		public MyPenel() {
			try {
				srcImg = ImageIO.read(new File("src/main/resources/Deck.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 저장할 1개의 이미지 크기
			width = srcImg.getWidth() / 13;
			height = srcImg.getHeight() / 5;
			// 반복문을 돌려서 1개씩 잘라 배열에 저장해보자
			int k = 0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 13; j++) {
					img[k] = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
					Graphics g = img[i].getGraphics();
					// 원본이미지에서 필요한 부분만 잘라서 만든이미지에 복사
					g.drawImage(srcImg, 0, 0, width, height, j * width, i * height, (j + 1) * width, (i + 1) * height,
							this);
					// 잘라낸 이미지 저장
					try {
						ImageIO.write(img[i], "png",
								new File("src/main/resources/cards/cards_" + String.format("%02d", k) + ".png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					++k; // 이미지 번호 증가
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
