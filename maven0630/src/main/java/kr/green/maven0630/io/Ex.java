package kr.green.maven0630.io;

import java.io.FileWriter;

public class Ex {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("text.txt");
			fw.write("하");
		} catch (Exception e) {
		}
	}
}
