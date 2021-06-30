package kr.green.maven0629.textio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// FileReader 를 이용한 텍스트 파일 읽기
public class Ex2 {
	static String fileName = "src/main/resource/koreansong.txt";

	public static void main(String[] args) {
		// 2. 열기
		try(FileReader fr = new FileReader(fileName)) {
			// 3. 사용
			int n;
			/*
			while ((n = fr.read()) > 0) { // 1글자씩 읽기
				System.out.print((char) n);
			}*/
			char[] data = new char[1024]; // 1번에 읽을 크기
			while ((n = fr.read(data)) > 0) { // 1글자씩 읽기
				System.out.print(new String(data, 0, n)); // char 배열을 String으로 읽은 글자수만큼만
			}
		
			System.out.println("읽기 완료!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
