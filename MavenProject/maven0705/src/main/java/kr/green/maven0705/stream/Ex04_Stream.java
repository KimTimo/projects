package kr.green.maven0705.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ex04_Stream {
	public static void main(String[] args) {
		String str = "1234,qwertym3m12,6";
		str.chars().filter(n -> !Character.isDigit((char) n) && !Character.isWhitespace((char) n))
				.forEach(n -> System.out.println((char) n));
		
		// 정규표현식을 이용한 스트림 만들기
		str = "XML,CSS,HTML";
		Pattern.compile(",").splitAsStream(str).forEach(System.out::println);
		
		// 파일을 이용한 스트림 만들기
		Path path = Paths.get("pom.xml");
		try(Stream<String> lines = Files.lines(path)){
			lines.forEach(System.out::println);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		Path dir = Paths.get(".");
		System.out.printf("%nThe file tree for %s%n", dir.toAbsolutePath());
		try(Stream<Path> fileTree = Files.walk(dir)){
			fileTree.forEach(System.out::println);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
