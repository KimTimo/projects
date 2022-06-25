package kr.green.text_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

// Files.newBufferedReader를 이용한 텍스트 파일 읽기
public class Ex06_TextFileReader6 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
