package kr.green.text_reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// InputStreamReader를 이용한 텍스트 파일 읽기
public class Ex04_TextFileReader4 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName))){
			StringBuilder sb = new StringBuilder();
			int n=0;
			while((n=isr.read())>0) {
				sb.append((char)n);
			}
			System.out.println(sb);
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		char[] chars = new char[1024];
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName))){
			StringBuilder sb = new StringBuilder();
			int len=0;
			while((len=isr.read(chars))>0) {
				sb.append(new String(chars, 0, len));
			}
			System.out.println(sb);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
