package kr.green.maven0708.chat3;

import java.io.IOException;
import java.net.Socket;

public class MyChatClient {
	public static void main(String[] args) {
		// 1. 준비
		Socket clientSocket = null;

		try {
			System.out.println("127.0.0.1 서버의 9999포트에 접속을 시도합니다.");
			// 2. 서버에 접속
			clientSocket = new Socket("127.0.0.1", 9999);
			System.out.println("접속 성공 : " + clientSocket);
			// 3. 사용
			// 받기 보내기를 스레드가 한다....
			ReceiveThread receiveThread = new ReceiveThread(clientSocket);
			SendThread sendThread = new SendThread(clientSocket);
			// 스레드 시작
			receiveThread.start();
			sendThread.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 닫기
			/* 다른 스레드에서 사용 중이므로 닫으면 않된다.
			try {
				if(clientSocket!=null) clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
		}
	}
}
