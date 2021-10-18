package kr.green.text_reader;

import java.io.FileReader;
import java.io.IOException;
// FileReader를 이용한 텍스트 파일 읽기
public class Ex02_TextFileReader2 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		try(FileReader fr = new FileReader(fileName)){
			StringBuilder sb = new StringBuilder();
			int ch=0;
			while((ch=fr.read())>0) {
				sb.append((char)ch);
			}
			System.out.println(sb);
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		char[] chars = new char[1024];
		try(FileReader fr = new FileReader(fileName)){
			StringBuilder sb = new StringBuilder();
			int len=0;
			while((len=fr.read(chars))>0) {
				sb.append(new String(chars, 0, len));
			}
			System.out.println(sb);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
