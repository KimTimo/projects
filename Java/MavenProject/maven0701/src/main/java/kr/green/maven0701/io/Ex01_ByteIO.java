package kr.green.maven0701.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * 바이트 단위 입출력 : 클래스이름이 Stream으로 끝난다.
 *                      InputStream 과 OutputStream의 자식들이다.
 */
public class Ex01_ByteIO {
	public static void main(String[] args) {
		// Byte단위 저장
		// 1. 준비
		FileOutputStream fos = null;
		try {
			// 2. 열기
			fos = new FileOutputStream("sample.dat");
			// 3. 사용
			fos.write(100);
			fos.write(new byte[] {1,2,3,4,5});
			fos.write(new byte[] {6, 7, 8, 9, 10}, 2, 2);
			fos.write("한사람".getBytes());
			fos.flush();
			System.out.println("바이트 단위 저장 완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4. 닫기
				if(fos!=null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Byte단위 읽기
		try(FileInputStream fis = new FileInputStream("sample.dat")){
			int n = fis.read();
			System.out.println(n);
			System.out.println(fis.read());
			byte[] data = new byte[6];
			fis.read(data);
			System.out.println(Arrays.toString(data));
			// 문자열 읽기
			byte[] str = new byte[10];
			fis.read(str);
			System.out.println(Arrays.toString(str) + " : " + new String(str));
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
