package kr.green.maven0701.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 자식은 직렬화 역직렬화를 구현 했지만 부모는 구현하지 앟은 경우!!!!!!!!!!!! 
// 자식들 데이터만 저장된다.
// 이때 부모 클래스를 수정 할수 없는 경우라면 어떻게해야 부모의 데이터를 저장하고 읽어올 수 있을까?
// 이때는 사용자가 직접 직렬화/역직렬화 메서드를 자식 클래스에 구현해주면 된다.
public class Ex11_ObjectIO {
	public static void main(String[] args) {
		ObjectOutputStream dos = null;
		try {
			dos = new ObjectOutputStream(new FileOutputStream("data11.dat"));
			
			Child child = new Child("한사람", 22, "admin", "12345");
			dos.writeObject(child);
			
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { if (dos != null) dos.close(); } catch (IOException e) { ; }
		}
	
		try (ObjectInputStream dis = new ObjectInputStream(new FileInputStream("data11.dat"))) {
			
			Child child = (Child)dis.readObject();
			System.out.println("읽은 값 : " + child);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
