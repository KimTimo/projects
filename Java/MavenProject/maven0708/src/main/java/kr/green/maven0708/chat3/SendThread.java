package kr.green.maven0708.chat3;
// 보내는 스레드
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class SendThread extends Thread {
	Socket socket;	// 통신
	PrintWriter pw;	// 보낼때
	Scanner sc;		// 입력받을때
	
	// 생성자에서 Socket을 받아 보낼 준비를 하자
	public SendThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		super.run();
		try {
			pw = new PrintWriter(socket.getOutputStream());
			sc = new Scanner(System.in);
			String message="";
			while(!message.equalsIgnoreCase("bye")) {
				System.out.print("보낼내용 : ");
				message = sc.nextLine();
				pw.write(message + "\n");
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sc!=null) sc.close();
			if(pw!=null) pw.close();
		}
	}
}
