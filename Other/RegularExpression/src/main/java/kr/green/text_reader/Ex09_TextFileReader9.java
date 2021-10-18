package kr.green.text_reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
// Files.readString을 이용한 텍스트 파일 읽기
public class Ex09_TextFileReader9 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		
		try {
			String content = Files.readString(Paths.get(fileName), StandardCharsets.UTF_8);
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
