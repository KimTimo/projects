package kr.green.maven0701.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

// 객체를 입출력하기 : ObjectInputStream, ObjectOutputStream 
//                     사용자가 작성한 클래스도 저장이 될까요?
public class Ex07_ObjectIO {
	public static void main(String[] args) {
		ObjectOutputStream dos = null;
		// 사용자가 작성한 클래스도 저장하려면 반드시 사용자클래스가 직렬화/역직렬화 인터페이스를 구현해햐 한다. Serializable인터페이스를 구현해 주어야 한다.
		try {
			dos = new ObjectOutputStream(new FileOutputStream("data4.dat"));
			// 직렬화 : 자바 객체를 스트림으로 만드는것
			SimpleData data = new SimpleData("나이름", 33, new Date(102, 2, 31));
			dos.writeObject(data);
			
			System.out.println(data + "를 저장함!!");
			
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { if (dos != null) dos.close(); } catch (IOException e) { ; }
		}
		// 역 직렬화 : 저장된 스트림을 자바 객체로 만드는 것
		try (ObjectInputStream dis = new ObjectInputStream(new FileInputStream("data4.dat"))) {
			SimpleData simpleData = (SimpleData) dis.readObject();
			System.out.println(simpleData);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
