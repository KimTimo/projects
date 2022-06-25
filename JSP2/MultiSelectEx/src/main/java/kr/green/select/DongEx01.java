package kr.green.select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DongEx01 {
	public static void main(String[] args) throws IOException {
		
		String filename = "src/main/resources/dong.txt";
		Path path = Paths.get(System.getProperty("user.dir"), filename);
		List<String> allLines = Files.readAllLines(path);
		System.out.println(allLines.size() + "줄~~~~");
		System.out.println("--------------------------------------------------------");
		System.out.println("광역시도");
		System.out.println("--------------------------------------------------------");
		for(String temp : allLines) {
			if(temp.contains("00000000") && temp.contains("존재")) {
				System.out.println(temp);
			}
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("서울시 구만 표시");
		System.out.println("--------------------------------------------------------");
		for(String temp : allLines) {
			if(temp.startsWith("11") && !temp.startsWith("1100") && temp.contains("000000") && temp.contains("존재")) {
				System.out.println(temp);
			}
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("서울시 종로구만 표시");
		System.out.println("--------------------------------------------------------");
		int count = 0;
		for(String temp : allLines) {
			if(temp.startsWith("1111") && !temp.startsWith("111100") && temp.contains("존재")) {
				count++;
				System.out.println(temp);
			}
		}
		System.out.println(count + "개");
	}
}
