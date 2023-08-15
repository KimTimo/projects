package kr.green.maven0708.chat1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		Socket clientSocket = null;
		PrintWriter pw = null;
		Scanner scanner = null;

		try {
			System.out.println("127.0.0.1 서버의 10004포트에 접속을 시도합니다.");
			// 2. 서버에 접속
			clientSocket = new Socket("127.0.0.1", 10052);
			System.out.println("접속 성공 : " + clientSocket);
			// 3. 사용
			// 데이터를 주고받기위해서 IOStream을 만들어 통신을 수행하게 된다.
			pw = new PrintWriter(clientSocket.getOutputStream()); // 문자열을 보낼 객체
			scanner = new Scanner(clientSocket.getInputStream()); // 문자열을 받을 객체
			// 받기
			System.out.println("받은 내용 : " + scanner.nextLine());
			
			// 보내기
			pw.write("김대현\n");
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 닫기
			try {
				if(scanner != null) scanner.close();
				if(pw != null) pw.close();
				if(clientSocket != null) clientSocket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
