package kr.green.maven0708.chat5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PerClientThread extends Thread {
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<>());

	Socket socket;
	PrintWriter pw;

	public PerClientThread() {
		this.socket = socket;
		try {
			pw = new PrintWriter(this.socket.getOutputStream());
			list.add(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		super.run();
		String name = null;
		Scanner sc = null;
		try {
			sc = new Scanner(socket.getInputStream());
			name = sc.nextLine().trim();
			sendAll("#" + name + "님이 입장하셧습니다.");
			sendAll("# 현재 " + list.size() + "명이 대화중입니다.");
			while (true) {
				String message = sc.nextLine();
				if (message == null)
					break;
				sendAll(name + ">" + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sendAll("#" + name + "님이 퇴장하셧습니다.");
			sendAll("# 현재 " + list.size() + "명이 대화중입니다.");
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void sendAll(String message) {
		for (PrintWriter pw : list) {
			pw.println(message);
			pw.flush();
		}
	}

}
