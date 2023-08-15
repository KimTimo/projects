package kr.green.maven0701.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/*
 * 파일을 복사해 보자
 */
public class Ex02_ByteIO_ImageDownload {
	public static void main(String[] args) {
		// 1. 준비
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			URL url = new URL("https://cdn-naning9.bizhost.kr/files/new_main/1624934771_0.jpg");
			is = url.openStream();
			fos = new FileOutputStream("image.jpg");
			byte[] data = new byte[1024];
			int len = 0;
			// 읽어서 쓴다.
			while((len = is.read(data))>0) { // 읽기를 하면 길이가 리턴된다.
				fos.write(data, 0, len);
				fos.flush();
			}
			System.out.println("이미지 저장 완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { // 열기 역순으로 닫아라
				fos.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
