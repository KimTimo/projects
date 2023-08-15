package kr.green.text_reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// Files.lines을 이용한 텍스트 파일 읽기
public class Ex07_TextFileReader7 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		try {
			Files.lines(Paths.get(fileName)).forEachOrdered(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
