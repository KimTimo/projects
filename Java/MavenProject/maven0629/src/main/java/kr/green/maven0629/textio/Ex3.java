package kr.green.maven0629.textio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// FileReader 를 이용한 텍스트 파일 읽기
// BufferedReader 로 한번감싸주면 1줄씩 읽는 메소드가 존해함
public class Ex3 {
	static String fileName = "src/main/resource/koreansong.txt";

	public static void main(String[] args) {
		// 2. 열기
		try(BufferedReader fr = new BufferedReader(new FileReader(fileName))) {
			// 3. 사용
			String line = "";
			while((line=fr.readLine())!= null)
				System.out.println(line);
		
			System.out.println("읽기 완료!!");
		}  catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
