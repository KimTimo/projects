package kr.green.maven0708.chat2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class WhoisClient {

	public static void main(String[] args) {
		String domainName = JOptionPane.showInputDialog("검색할 도메인을 입력하시오.", "naver.com");
		String hostName = "whois.internic.net";
		int port = 43;

		try (Socket socket = new Socket(hostName, port)) {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(domainName);
			pw.flush();
			Scanner scanner = new Scanner(socket.getInputStream());
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
			pw.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
