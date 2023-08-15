package kr.green.maven0708.chat1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {
	public static void main(String[] args) {
		// 1. 준비
		Socket clientSocket = null;
		Scanner scanner = null;
		
		try {
			System.out.println("127.0.0.1 서버의 9999포트에 접속을 시도합니다.");
			// 2. 서버에 접속
			clientSocket = new Socket("192.168.0.12", 9999);
			System.out.println("접속 성공 : " + clientSocket);
			// 3. 사용
			// 서버에서 시간을 받아온다.
			scanner = new Scanner(clientSocket.getInputStream()); // 문자열을 받을 객체
			// 받기
			System.out.println("서버 시간 : " + scanner.nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 닫기
			try {
				if(scanner!=null) scanner.close();
				if(clientSocket!=null) clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
