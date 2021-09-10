package kr.green.maven0706.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Ex01_ImageDraw extends JFrame {
	BufferedImage bi = null;  // 메모리상의 이미지를 저장할 변수
	BufferedImage img = null; // 이미지 파일을 읽어서 저장할 변수
	int width, height; // 이미지의 폭과 높이를 저장할 변수
	
	public Ex01_ImageDraw() {
		try {
			// 이미지읽기
			img = ImageIO.read(new File("src/main/resources/ship2_1.png"));
			// 이미지의 폭과 높이를 구하자
			width = img.getWidth();
			height = img.getHeight();
			System.out.println(width + ", " + height);
			// 버퍼에 임시 이미지 생성(버튼에 입힐 이미지크기)
			// bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			bi = new BufferedImage(width*2, height*2, BufferedImage.TYPE_INT_RGB);
			// 그래픽스 객체 얻기
		    Graphics g = bi.getGraphics();
		    g.setColor(Color.WHITE); // 색상지정
		    g.fillRect(0, 0, width, height); // 채운 사각형으로 그리기
		    // g.drawImage(img, 0, 0, null); // 이미지 그리기 : (이미지, 그릴 x좌표, 그릴 y좌표, 옵저버)
		    // g.drawImage(img, 0, 0,Color.BLUE, null); // 이미지 그리기 : (이미지, 그릴 x좌표, 그릴 y좌표,배경색, 옵저버)
		    // g.drawImage(img, 0, 0, width/2,height/2, null); // 이미지 그리기 : (이미지, 그릴 x좌표, 그릴 y좌표,폭, 높이, 옵저버)
		    // g.drawImage(img, 0, 0, width,height, null); // 이미지 그리기 : (이미지, 그릴 x좌표, 그릴 y좌표,폭, 높이, 옵저버)
		    // g.drawImage(img, 0, 0, width*2,height*2, null); // 이미지 그리기 : (이미지, 그릴 x좌표, 그릴 y좌표,폭, 높이, 옵저버)
		    g.drawImage(img, 0, 0, width*2,height*2,Color.WHITE, null); // 이미지 그리기 : (이미지, 그릴 x좌표, 그릴 y좌표,폭, 높이, 배경색, 옵저버)
		    
		    setSize(400,400);
		    // setLayout(new FlowLayout());
		    // 잘라낸이미지를 버튼에 입히기
		    JButton btn = new JButton(new ImageIcon(bi)); // 버튼에 아이콘 지정
		    add(btn);
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		    setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Ex01_ImageDraw();
	}
}
