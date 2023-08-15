package kr.green.exception1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
		// 외부 자원을 사용할 경우에는 대부분 try~catch를 반드시 써줘야 한다.
		// 1. 변수 준비
		FileReader fr = null;
		try {
			// 2. 열기 
			fr = new FileReader("test.txt");
			// 3. 사용
			char[] str = new char[1024]; // 1번에 읽어들일 글자의 갯수
			int len = 0;
			while((len=fr.read(str))>0) {
				System.out.println(new String(str,0,len));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 4. 닫기
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
