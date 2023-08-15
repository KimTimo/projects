package kr.green.text_reader;

import java.io.File;
import java.util.Scanner;
// Scanner를 이용한 텍스트 파일 읽기
public class Ex05_TextFileReader5 {
	public static void main(String[] args) {
		String fileName = "src/main/resources/NationalAnthem.txt";
		try(Scanner sc = new Scanner(new File(fileName))){
			StringBuilder sb = new StringBuilder();
			while(sc.hasNextLine()) {
				sb.append(sc.nextLine());
				sb.append(System.lineSeparator());
			}
			System.out.println(sb);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
