package kr.green.maven0706.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ex02_ImageDraw extends JFrame {

	BufferedImage img = null; // 이미지 파일을 읽어서 저장할 변수
	BufferedImage bi[] = new BufferedImage[10];  // 임시 이미지 파일을 저장할 변수
	int width, height; // 이미지의 폭과 높이를 저장할 변수

	public Ex02_ImageDraw() {
		setTitle("이미지 그리기");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex02_ImageDraw();
	}

	class MyPanel extends JPanel {

		public MyPanel() {
			// 이미지읽기
			try {
				img = ImageIO.read(new File("src/main/resources/ship2_1.png"));
				// 이미지의 폭과 높이를 구하자
				width = img.getWidth();
				height = img.getHeight();
				// 그대로 복사
				bi[0] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // 원본이미지와 크기가 같은 이미지를 메모리에 생성
				// 그래픽스 객체 얻기
			    Graphics g = bi[0].getGraphics();
			    // 원본이미지에서 필요한 부분만 잘라서 그리기
			    g.drawImage(img, 0, 0, width, height, 0, 0, width, height, Color.WHITE, this); // 원본을 그대로 복사
				
			    // 좌우 반전
			    bi[1] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // 원본이미지와 크기가 같은 이미지를 메모리에 생성
			    // 그래픽스 객체 얻기
			    g = bi[1].getGraphics();
			    // 원본이미지에서 필요한 부분만 잘라서 그리기
			    g.drawImage(img, 0, 0, width, height, width, 0, 0, height, Color.WHITE, this); // 원본을 그대로 복사
			    
			    // 상하 반전
			    bi[2] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // 원본이미지와 크기가 같은 이미지를 메모리에 생성
			    // 그래픽스 객체 얻기
			    g = bi[2].getGraphics();
			    // 원본이미지에서 필요한 부분만 잘라서 그리기
			    g.drawImage(img, 0, 0, width, height, 0, height, width, 0, Color.WHITE, this); // 원본을 그대로 복사
			    
			    // 상하좌우 반전
			    bi[3] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // 원본이미지와 크기가 같은 이미지를 메모리에 생성
			    // 그래픽스 객체 얻기
			    g = bi[3].getGraphics();
			    // 원본이미지에서 필요한 부분만 잘라서 그리기
			    g.drawImage(img, 0, 0, width, height, width, height, 0, 0, Color.WHITE, this); // 원본을 그대로 복사
			    
			    // 폭을 2배 확대
			    bi[4] = new BufferedImage(width*2,height,BufferedImage.TYPE_INT_RGB); // 원본이미지와 크기가 같은 이미지를 메모리에 생성
			    // 그래픽스 객체 얻기
			    g = bi[4].getGraphics();
			    // 원본이미지에서 필요한 부분만 잘라서 그리기
			    g.drawImage(img, 0, 0, width*2, height, 0, 0,width, height, Color.WHITE, this); // 원본을 그대로 복사
			    
			    // 높이를 2배 확대
			    bi[5] = new BufferedImage(width,height*2,BufferedImage.TYPE_INT_RGB); // 원본이미지와 크기가 같은 이미지를 메모리에 생성
			    // 그래픽스 객체 얻기
			    g = bi[5].getGraphics();
			    // 원본이미지에서 필요한 부분만 잘라서 그리기
			    g.drawImage(img, 0, 0, width, height*2, 0, 0,width, height, Color.WHITE, this); // 원본을 그대로 복사
			    
			    // 우측상단의 1/4만  4배 확대
			    bi[6] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // 원본이미지와 크기가 같은 이미지를 메모리에 생성
			    // 그래픽스 객체 얻기
			    g = bi[6].getGraphics();
			    // 원본이미지에서 필요한 부분만 잘라서 그리기
			    g.drawImage(img, 0, 0, width, height, width/2, 0, width, height/2, Color.WHITE, this); // 원본을 그대로 복사
			    
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void paint(Graphics g) {
			if(img!=null) {
				g.drawImage(bi[0], 0, 0, null);
				g.drawImage(bi[1], width, 0, null);
				g.drawImage(bi[2], 0, height, null);
				g.drawImage(bi[3], width, height, null);
				g.drawImage(bi[4], 0, height*2, null);
				g.drawImage(bi[5], 0, height*3, null);
				g.drawImage(bi[6], width*2, 0, null);
			}
		}
	}
}
/*
 * 오늘의 과제 1 : 이미지 8장을 1장으로 합쳐 저장하시오!!!!
 * 오늘의 과제 2 : 이미지 4장을 이용하여 비행기가 가는것처럼 보이도록하시오!!!
 */





