package kr.green.maven0708.chat1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeServer {

	public static void main(String[] args) {
		// 1. 준비
		ServerSocket serverSocket = null;
		PrintWriter pw = null;
		// 2. 연결
		try {
			System.out.println("10052번 포트를 열어서 타임서버를 시작합니다.");
			serverSocket = new ServerSocket(10052);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			while(true) {
				System.out.println("클라이언트의 접속을 무한 대기 합니다.");
				Socket clientSocket = serverSocket.accept(); // 접속되면 Socket을 리턴한다. 통신은 Socket끼리 통신을 합니다.
				System.out.println("연결성공 : " + clientSocket);
				// 데이터를 주고받기 위해서 IOStream을 만들어 통신을 수행하게 됩니다.
				// 3. 사용
				pw = new PrintWriter(clientSocket.getOutputStream()); // 문자열을 보낼 객체
				pw.write(sdf.format(new Date()) + "\n");
				pw.flush();
				pw.close();
				clientSocket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 닫기
			if (pw != null)
				pw.close();
			try {
				if (serverSocket != null)
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
