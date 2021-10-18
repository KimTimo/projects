package kr.green.text_reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// Files.readAllBytes을 이용한 텍스트 파일 읽기
public class Ex08_TextFileReader8 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		
		try {
			byte[] data = Files.readAllBytes(Paths.get(fileName));
			String content = new String(data);
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
