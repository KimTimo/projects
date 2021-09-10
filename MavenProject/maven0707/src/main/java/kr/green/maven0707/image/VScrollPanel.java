package kr.green.maven0707.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VScrollPanel extends JPanel implements Runnable {
	BufferedImage lottoImg; // 합쳐서 저장할 이미지
	int width, height; // 이미지 한장의 크기
	int ny = 0, speed, num, repeat;

	// 생성자에서 모든 이미지를 읽어서 넣자!!!
	public VScrollPanel(int num, int speed, int repeat) {
		this.num = num; // 로또번호
		this.speed = speed; // 속도
		this.repeat = repeat; // 몇번만에 멈출까요?
		// 원본 이미지 읽기
		try {
			lottoImg = ImageIO.read(new File("src/main/resources/lotto_ball_vert.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 이미지 크기
		width = lottoImg.getWidth();
		height = lottoImg.getHeight();
		// 스레드 시작
		Thread thread = new Thread(this);
		thread.start();
	}

	// 그려보자
	@Override
	public void paint(Graphics g) {
		// 번호 1개의 크기로 그리기
		g.drawImage(lottoImg, 0, 0, width, height / 46, 0, ny, width, ny + height / 46, this); // 번호 1개크기만 출력
	}

	@Override
	public void run() {
		while (true) {
			ny += 2; // 이미지 스크롤 크기
			if (ny >= height - height / 46) // 반복
				ny = 0; // 이미지 끝에도달하면 다시 0으로
			repeat--; // 반복횟수 감소
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
			// 종료를 지정한다 : 반복횟수값이 0 이면서 높이가 번호 높이가 되면
			if (repeat == 0 && ny >= height / 46 * num - 1) {
				break; // 반복문을 종료하여 스레드를 멈춘다.
			}
		}
	}
}
