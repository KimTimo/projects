package kr.green.maven0701.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// 객체를 입출력하기 : ObjectInputStream, ObjectOutputStream 
public class Ex06_ObjectIO {
	public static void main(String[] args) {
		ObjectOutputStream dos = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
		// 객체 타입에 맞게 저장하기!!!!
		try {
			dos = new ObjectOutputStream(new FileOutputStream("data3.dat"));
			
			Date today = new Date();
			dos.writeObject(today); // 클래스 객체를 저장했다.
			System.out.println("저장시간 : " + sdf.format(today));
			
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { if (dos != null) dos.close(); } catch (IOException e) { ; }
		}
		
		// 1/1000초 단위로 프로그램을 일시 정지 시킨다.
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		// 객체 타입에 맞게 읽기
		try (ObjectInputStream dis = new ObjectInputStream(new FileInputStream("data3.dat"))) {
			
			Date date = (Date) dis.readObject(); // 읽을때는 반드시 형변환해 주어야 한다.
			System.out.println("읽은시간 : " + sdf.format(date));
			System.out.println("현재시간 : " + sdf.format(new Date()));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
