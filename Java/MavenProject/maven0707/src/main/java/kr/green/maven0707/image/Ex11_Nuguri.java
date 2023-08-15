package kr.green.maven0707.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ex11_Nuguri extends JFrame implements KeyListener {
	int orientation = 0; // 방향
	int swx = 1, swy = 1; // 반전시키기 위한 변수
	boolean flag = false; // x값이 변경될지 y값이 변경될지를 지정
	int nowx = 100, nowy = 100; // 너구리가 나타날 최초의 위치

	public Ex11_Nuguri() {
		setTitle("너굴맨 Ver 0.001");
		setSize(1000, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);

		// 키 이벤트 지정
		addKeyListener(this);

		add(new Nuguri());

		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex11_Nuguri();
	}

	// 키 이벤트 구현
	@Override
	public void keyTyped(KeyEvent e) {
		;
	} // 키가 입력될 때

	@Override
	public void keyPressed(KeyEvent e) { // 키가 눌릴 때
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			orientation = 9;
			swy = -1;
			flag = false;
			break;
		case KeyEvent.VK_DOWN:
			orientation = 0;
			swy = 1;
			flag = false;
			break;
		case KeyEvent.VK_LEFT:
			orientation = 3;
			swx = -1;
			flag = true;
			break;
		case KeyEvent.VK_RIGHT:
			orientation = 6;
			swx = 1;
			flag = true;
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		;
	} // 키가 눌렸다가 떨어질 때

	class Nuguri extends JPanel implements Runnable {
		// ----------------------------------------------------------------------------
		// 변수 선언
		BufferedImage srcImg;
		BufferedImage[] src = new BufferedImage[12];
		String srcImageName = "src/main/resources/Nuguri.png"; // 원본이미지 이름
		int width, height;
		int index = 0; // 0, 1, 2 를 반복

		// 생성자

		public Nuguri() {
			// 원본 이미지 읽기
			try {
				srcImg = ImageIO.read(new File(srcImageName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			width = srcImg.getWidth() / 14;
			height = srcImg.getHeight() / 8;
			// 원본 이미지를 잘라 배열에 넣기
			int k = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					src[k] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
					Graphics g = src[k].getGraphics();
					g.drawImage(srcImg, 0, 0, width, height, j * width, i * height, (j + 1) * width, (i + 1) * height,
							Color.WHITE, this);
					k++;
				}
			}

			// 스레드 시작
			Thread thread = new Thread(this);
			thread.setDaemon(true);
			thread.start();
		}

		// ----------------------------------------------------------------------------
		// 이미지 출력
		@Override
		public void paint(Graphics g) {
//			for (int i = 0; i < src.length; i++) {
//				g.drawImage(src[i], i * width, 0, null);
//			}

			// 이미지를 확대해서 출력해보자
			g.drawImage(src[index + orientation], nowx, nowy, nowx+80, nowy+80, 0, 0, width, height, null);
		}

		// ----------------------------------------------------------------------------
		// 스레드 구현
		@Override
		public void run() {
			while (true) {
				index = ++index % 3;
				// 현재 위치값을 변경해 준다.
				if(flag) {
					nowx += swx*5;
				}else {
					nowy += swy*5;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		}

	}
}
