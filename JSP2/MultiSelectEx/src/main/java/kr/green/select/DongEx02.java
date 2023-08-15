package kr.green.select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DongEx02 {
	public static void main(String[] args) throws IOException {
		
		String filename = "src/main/resources/dong.txt";
		Path path = Paths.get(System.getProperty("user.dir"), filename);
		List<String> allLines = Files.readAllLines(path);
		
		
		String line = allLines.get(3); // 네번째 줄
		System.out.println(line);
		
		String[] lines = line.split("\t");
		System.out.println(lines.length + "개");
		
		System.out.println("코드 : " + lines[0]);
		System.out.println("이름 : " + lines[1]);
		System.out.println("존재여부 : " + lines[2]);
		
		String[] dongs = lines[1].split(" ");
		System.out.println("동이름 : " + dongs[dongs.length-1]);
		
		
		System.out.println("--------------------------------------------------------");
		System.out.println("서울시 종로구 동이름만 표시");
		System.out.println("--------------------------------------------------------");
		Set<String> dongSet = new TreeSet<>();
		for(String temp : allLines) {
			if(temp.startsWith("1111") && !temp.startsWith("111100") && temp.contains("존재")) {
				String[] dongArray = temp.split("\t")[1].split(" ");
				dongSet.add(dongArray[dongArray.length-1]);
			}
		}
		System.out.println(dongSet.size() + "개동!!!");
		for(String dong : dongSet) {
			System.out.println(dong);
		}
		
	}
}
