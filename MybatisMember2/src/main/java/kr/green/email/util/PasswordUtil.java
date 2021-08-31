package kr.green.email.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class PasswordUtil {
	// 인증 문자 만들기
	public static String generateAuth(int len) {
		String makeStr = "";
		Random rnd = new Random();
		for(int i=0;i<len;i++) {
			if(rnd.nextBoolean()) { // 난수로 논리값 만듬
				makeStr += rnd.nextInt(10); // 숫자 생성
			}else {
				// 문자 생성
				makeStr += (char) (rnd.nextInt(26) + (rnd.nextBoolean()?'A':'a'));
			}
		}
		return makeStr;
	}
	// 인증 이미지 만들기 -- 도배방지기능에서 사용하시오!!!
	public static String generateImageAuth(int len, String path) {
		String makeStr = "";
		Random rnd = new Random();
		for(int i=0;i<len;i++) {
			if(rnd.nextBoolean()) { // 난수로 논리값 만듬
				makeStr += rnd.nextInt(10); // 숫자 생성
			}else {
				// 문자 생성
				makeStr += (char) (rnd.nextInt(26) + (rnd.nextBoolean()?'A':'a'));
			}
		}
		// 이미지로 저장하자
		BufferedImage img = new BufferedImage(130, 25, BufferedImage.TYPE_INT_BGR);
		Graphics2D graphics = img.createGraphics();
		graphics.setColor(Color.GREEN);
		graphics.fillRect(0, 0, 130, 25);
		graphics.setColor(Color.GRAY);
		graphics.setFont(new Font("굴림", Font.BOLD, 15));
		graphics.drawString(makeStr,10, 20);
		File file = new File(path + File.separator + makeStr + ".jpg");
		System.out.println("이미지 저장 경로 : " + path);
		try {
			ImageIO.write(img, "jpg", file);
			System.out.println("저장완료!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return makeStr;
	}
	// 테스트
	public static void main(String[] args) {
		for(int i=0;i<30;i++) {
			System.out.println(generateAuth(10));
		}
	}
}
