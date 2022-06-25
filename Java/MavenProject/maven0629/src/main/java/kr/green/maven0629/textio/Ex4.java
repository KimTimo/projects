package kr.green.maven0629.textio;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Scanner 를 이용한 텍스트 파일 읽기
public class Ex4 {
	static String fileName = "src/main/resource/koreansong.txt";

	public static void main(String[] args) {
		// 2. 열기
		try(Scanner sc = new Scanner(new File(fileName))) {
			// 3. 사용
			while(sc.hasNextLine())
				System.out.println(sc.nextLine());
		
			System.out.println("읽기 완료!!");
		}  catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
