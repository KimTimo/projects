package kr.green.maven0629.textio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// Files.readAllLInes 를 이용한 텍스트 파일 읽기
public class Ex5 {
	static String fileName = "src/main/resource/koreansong.txt";

	public static void main(String[] args) {
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			for(String line : lines) {
				System.out.println(line);
			}
			System.out.println("읽기 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------");
		
		try {
			Files.lines(Paths.get(fileName)).forEachOrdered(System.out::println);
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------");
		
		try {
			String data = Files.readString(Paths.get(fileName));
	        String content = new String(data);
	        System.out.println(content);
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
