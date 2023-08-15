package kr.green.maven0629.textio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// InputStreamReader를 이용한 텍스트 파일 읽기
public class Ex7 {
	static String fileName = "src/main/resources/song.txt";
	public static void main(String[] args) {
		// 2. 열기
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName),"UTF-8")) { // 자동닫기가 가능하다.
			// 3. 사용 : 배열만큼씩 읽기
			char[] data = new char[1024];
			int n;
			while((n=isr.read(data))>0) {
				System.out.print(new String(data,0,n));
			}
			System.out.println("읽기 완료!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 한번에 1줄씩 읽기
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"))) { // 자동닫기가 가능하다.
			// 3. 사용
			String line="";
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			System.out.println("읽기 완료!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
