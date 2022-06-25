package kr.green.maven0707.image;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ex09_DrawImage extends JFrame {
	public Ex09_DrawImage() {
		setTitle("로또 스크롤 시키기");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 6));
		add(new MyPenel(5)); // 이미지가 그려진 판넬을 윈도우에 붙이기
		add(new MyPenel(10)); // 이미지가 그려진 판넬을 윈도우에 붙이기
		add(new MyPenel(15)); // 이미지가 그려진 판넬을 윈도우에 붙이기
		add(new MyPenel(8)); // 이미지가 그려진 판넬을 윈도우에 붙이기
		add(new MyPenel(3)); // 이미지가 그려진 판넬을 윈도우에 붙이기
		add(new MyPenel(9)); // 이미지가 그려진 판넬을 윈도우에 붙이기
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex09_DrawImage();
	}

	class MyPenel extends JPanel implements Runnable {
		BufferedImage lottoImg; // 합쳐서 저장할 이미지
		int width, height; // 이미지 한장의 크기
		int ny = 0, speed;
		
		// 생성자에서 모든 이미지를 읽어서 넣자!!!
		public MyPenel(int speed) {
			this.speed = speed;
			try {
				lottoImg = ImageIO.read(new File("src/main/resources/lotto_ball_vert.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			width = lottoImg.getWidth();
			height = lottoImg.getHeight();

			Thread thread = new Thread(this);
			thread.setDaemon(true);
			thread.start();
		}

		// 그려보자
		@Override
		public void paint(Graphics g) {
			// 합쳐진 이미지를 출력해보자
			g.drawImage(lottoImg, 0, 0, width, height / 46, 0, ny, width, ny + height / 46, this); // 번호 1개크기만 출력
		}

		@Override
		public void run() {
			while (true) {
				ny++;
				if (ny >= height - height / 46)
					ny = 0; // 이미지 끝에도달하면 다시 0으로
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		}
	}
}
