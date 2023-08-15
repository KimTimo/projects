package kr.green.maven0707.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ex06_DrawImage extends JFrame {
	public Ex06_DrawImage() {
		setTitle("카드를 쓰까보자");
		setSize(1100, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPenel()); // 이미지가 그려진 판넬을 윈도우에 붙이기
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex06_DrawImage();
	}

	class MyPenel extends JPanel {
		BufferedImage srcImg; // 합쳐진 이미지
		BufferedImage img[] = new BufferedImage[53]; // 잘라서 저장할 변수
		int width, height;
		// 게임에 사용할 배열
		int game[] = new int[52];

		public MyPenel() {
			try {
				srcImg = ImageIO.read(new File("src/main/resources/cards/cards.jpg"));
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
			}
			shuffle(); // 카드섞기 호출
		}
		// 카드섞기
		private void shuffle() {
			for(int i = 0; i < game.length; i++) game[i]=0; // 배열 초기화
			int temp = 0;
			Random random = new Random();
			for(int i = 0; i < game.length; i++) {
				do {
					temp = random.nextInt(game.length);
				}while(game[temp]!=0);
				game[temp] = i;
			}
		}

		// 그려보자
		@Override
		public void paint(Graphics g) {
			int j = 0;
			for(int i = 0; i < game.length; i++) {
				BufferedImage image = img[game[i]];
				g.drawImage(image, (i%13)*(width + 10) + 10 , j*(height + 10) + 10, null);
				if((i+1)%13==0) j++;
			}
		}

	}
}
