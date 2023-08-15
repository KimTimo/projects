package kr.green.maven0701.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 파일을 복사해 보자
 */
public class Ex02_ByteIO_FileCopy {
	public static void main(String[] args) {
		// 1. 준비
		FileOutputStream fos = null;
		FileInputStream fis = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("원본 파일명 입력 : ");
		String sourceFile = sc.nextLine();
		System.out.print("사본 파일명 입력 : ");
		String targetFile = sc.nextLine();
		try {
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(targetFile);
			byte[] data = new byte[1024];
			int len = 0;
			// 읽어서 쓴다.
			while((len = fis.read(data))>0) { // 읽기를 하면 길이가 리턴된다.
				fos.write(data, 0, len);
				fos.flush();
			}
			System.out.println(sourceFile + "을 " + targetFile + "로 복사를 했습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { // 열기 역순으로 닫아라
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
}
