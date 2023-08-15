package kr.co.green.util;

import javax.swing.JFrame;

public class Ex04 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("내가 맨든 윈도우!");
		frame.setSize(1280, 520);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
