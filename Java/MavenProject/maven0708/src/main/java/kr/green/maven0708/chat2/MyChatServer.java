package kr.green.maven0708.chat2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyChatServer {
	public static void main(String[] args) {
		// 1. 준비
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter pw = null;
		Scanner scanner = null;
		Scanner userScanner = new Scanner(System.in);
		// 2. 연결
		try {
			System.out.println("9999번 포트를 열어서 서버를 시작합니다.");
			serverSocket = new ServerSocket(9999);
			System.out.println("클라이언트의 접속을 무한 대기 합니다.......");
			clientSocket = serverSocket.accept(); // 접속되면 Socket을 리턴한다. 통신은 Socket끼리 통신을 합니다.
			System.out.println("연결성공 : " + clientSocket);

			// 3. 사용
			// 데이터를 주고받기위해서 IOStream을 만들어 통신을 수행하게 된다.
			pw = new PrintWriter(clientSocket.getOutputStream()); // 문자열을 보낼 객체
			scanner = new Scanner(clientSocket.getInputStream()); // 문자열을 받을 객체
			
			// 보내기, 받기
			String message="";
			do {
				// 보내기
				System.out.print("보낼내용 입력 : " );
				message = userScanner.nextLine();
				pw.write(message + "\n");
				pw.flush();
				// 받기
				message = scanner.nextLine(); 
				System.out.println("받은내용 : " + message);
			}while(message!=null && !message.equals(""));
			
			userScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 닫기
			if (scanner != null) scanner.close();
			if (pw != null) pw.close();
			try {
				if (clientSocket != null) clientSocket.close();
				if (serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
