package kr.green.exception1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		// 외부 자원을 사용할 경우에는 대부분 try~catch를 반드시 써줘야 한다.
		
		// 2. 열기 try(열기) 이렇게 Open하면 자동으로 Close 해준다. -- JDK 1.7에 추가된 기능
		try(FileReader fr = new FileReader("test.txt");) {
			// 3. 사용
			char[] str = new char[1024]; // 1번에 읽어들일 글자의 갯수
			int len = 0;
			while((len=fr.read(str))>0) {
				System.out.println(new String(str,0,len));
			}
		} catch (IOException e) { // Exception을 | 로 연결하여 catch의 개수를 줄일 수 있다. -- JDK 1.7에 추가된 기능
			e.printStackTrace();  // 예) catch(IOException | ClassCastException .... e)
		} 
	}

}
