package kr.green.text_reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
// Files.readAllLines을 이용한 텍스트 파일 읽기
public class Ex10_TextFileReader10 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			for(String line : lines) System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
