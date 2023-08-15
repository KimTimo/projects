package kr.green.text_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// BufferedReader를 이용한 텍스트 파일 읽기
public class Ex03_TextFileReader3 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			StringBuilder sb = new StringBuilder();
			String line="";
			while((line=br.readLine())!=null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			System.out.println(sb);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
