package kr.green.text_reader;

import java.io.FileInputStream;
import java.io.IOException;
// FileInputStream을 이용한 텍스트 파일 읽기
public class Ex01_TextFileReader1 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		try(FileInputStream fis = new FileInputStream(fileName)){
			StringBuilder sb = new StringBuilder();
			int ch=0;
			while((ch=fis.read())>0) {
				sb.append((char)ch);
			}
			System.out.println(sb);
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		byte[] bytes = new byte[1024];
		try(FileInputStream fis = new FileInputStream(fileName)){
			StringBuilder sb = new StringBuilder();
			int len=0;
			while((len=fis.read(bytes))>0) {
				sb.append(new String(bytes, 0, len));
			}
			System.out.println(sb);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
