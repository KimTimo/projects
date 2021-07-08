package kr.green.maven0708.runtime;

import java.io.IOException;
import java.util.Scanner;

public class RuntimeTest {

	public static void main(String[] args) {

		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		try {
			//runtime.exec("mspaint.exe");  // 그림판 실행
			process = runtime.exec("cmd /c ipconfig");
			Scanner sc = new Scanner(process.getInputStream(), "MS949");
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			new ProcessBuilder("cmd", "/c", "ipconfig").start();
			Scanner sc = new Scanner(process.getInputStream(), "MS949");
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
			
			new ProcessBuilder("cmd", "/c", "tree", "/f").start();
			sc = new Scanner(process.getInputStream(), "MS949");
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
