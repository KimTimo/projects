package kr.green.maven0706.window;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03_ChatWin extends JFrame implements ActionListener {
	JTextField messageTF;
	JTextArea messageTA;
	JButton sendBtn;

	public Ex03_ChatWin() {
		setTitle("허접한 채팅 Ver.0.0009");
		setSize(400, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// 하단에 입력창과 보내기 버튼 만들기
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());

		messageTF = new JTextField(30);
		messageTF.addActionListener(this);

		bottomPanel.add(messageTF);
		sendBtn = new JButton("전송");
		// 버튼을 클릭하면 내용이 위에 써져야 한다.
		sendBtn.addActionListener(this);

		bottomPanel.add(sendBtn);

		add(bottomPanel, BorderLayout.SOUTH);

		// 중앙에 채팅 내용이 보여질 부분
		messageTA = new JTextArea(20, 20);
		JScrollPane scrollPane = new JScrollPane(messageTA); // 스크롤바 붙이기
		messageTA.setEditable(false); // 편집불가
		messageTA.setFont(new Font("맑은고딕", Font.BOLD, 20));
		; // 폰트크기 변경
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex03_ChatWin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String message = messageTF.getText();
		if (message != null && message.trim().length() > 0) {
			messageTA.append("머현이>" + message.trim() + "\n"); // 채팅창으로 내용보내기
			messageTA.setCaretPosition(messageTA.getDocument().getLength()); // 문서의 끝으로 스크롤
			messageTF.setText(""); // 내용 지우기
			messageTF.requestFocus(); // 커서위치
		}

	}
}
