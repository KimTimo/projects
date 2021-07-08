package kr.green.maven0708.chat4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
// 메인스레드에서는 보내기를 하고 별도로 만든 스레드에서는 받기를 수행
@SuppressWarnings("serial")
public class GUIChatClient extends JFrame implements Runnable, ActionListener{
	// 프로그램에서 제어할 컴포넌트들을 필드로 선언
	JButton     sendBtn;
	JTextField   messageTF;
    JTextArea    messageTA;
    // 네트워크에 필요한 변수
    Socket      socket;  // 통신
    PrintWriter pw;      // 보내기
    Scanner     sc;      // 받기
	
    // 생성자에서 디자인
    public GUIChatClient() {
    	super("허접한 채팅 Ver 0.0009");
		setSize(400, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		// 하단 디자인
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());
		messageTF = new JTextField(28);
		messageTF.addActionListener(this);
		bottomPanel.add(messageTF);
		sendBtn = new JButton("전송");
		sendBtn.addActionListener(this);
		bottomPanel.add(sendBtn);
		add(bottomPanel, BorderLayout.SOUTH);
		//중앙디자인
		messageTA = new JTextArea(15, 33);
		messageTA.setEditable(false);
		messageTA.setFont(new Font("굴림" , Font.BOLD, 16));
		JScrollPane jScrollPane = new JScrollPane(messageTA);
		
		add(jScrollPane, BorderLayout.CENTER);
		
		setResizable(false);
		setVisible(true);
		
	}
    
	public static void main(String[] args) {
		GUIChatClient client = new GUIChatClient();
		client.sendBtn.setEnabled(false);
		client.messageTF.setEnabled(false);
		// 클라이언트 시작
		try {
			// 서버의 아이피 입력
			String hostName = JOptionPane.showInputDialog("접속할 서버의 ip입력", "127.0.0.1");
			
			// 접속대기
			client.messageTA.append("서버에 접속합니다.....\n");
			client.socket = new Socket(hostName, 9999);
			// 접속되면
			client.messageTA.append(client.socket.getInetAddress() + "의 서버에 접속했습니다......\n");
			client.pw = new PrintWriter(client.socket.getOutputStream());
			client.sc = new Scanner(client.socket.getInputStream());
			// 접속 후에는 버튼과 텍스트 필드 접근
			client.sendBtn.setEnabled(true);
			client.messageTF.setEnabled(true);
			client.messageTF.requestFocus(); // 커서위치 지정
			
			// 받는 스레드 시작
			Thread thread = new Thread(client);
			thread.setDaemon(true);
			thread.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String message = messageTF.getText();
		if(message!=null && message.trim().equals("")) {
			messageTA.append("머현이>" + message + "\n");
			messageTF.setText("");
			messageTF.requestFocus();
			// 상대방 화면에도 나와야 한다.
			pw.write(message + "\n");
			pw.flush();
		}
	}
	
	@Override
	public void run() {
		String message = "";
		while(!message.equalsIgnoreCase("Bye")) {
			message = sc.nextLine();
			messageTA.append("짱꾸요미> " + message + "\n");
		}
	}

}
