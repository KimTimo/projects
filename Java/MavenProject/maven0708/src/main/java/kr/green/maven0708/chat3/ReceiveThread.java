package kr.green.maven0708.chat3;
// 받는 스레드
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveThread extends Thread{
	// 받기 위해 소켓이 필요하다
	Socket socket;
	// 스캐너도 필요하다
	Scanner scanner;
	
	public ReceiveThread(Socket socket) {
		this.socket = socket;
		try {
			scanner = new Scanner(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		super.run();
		String message="";
		while(!message.equalsIgnoreCase("bye")) {
			message = scanner.nextLine();
			System.out.println("받은내용 : " + message);
		}
		try {
			if(scanner!=null) scanner.close();
			if(socket!=null) socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
