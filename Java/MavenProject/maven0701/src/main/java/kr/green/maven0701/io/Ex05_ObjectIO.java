package kr.green.maven0701.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 객체를 입출력하기 : ObjectInputStream, ObjectOutputStream 
public class Ex05_ObjectIO {
	public static void main(String[] args) {
		ObjectOutputStream dos = null;
		// 객체 타입에 맞게 저장하기!!!!
		try {
			dos = new ObjectOutputStream(new FileOutputStream("data2.dat"));
			dos.writeByte(123);
			dos.writeInt(0xAABBCCDD);
			dos.writeDouble(3.14);
			dos.writeUTF("문자열도 저장이 될까?");
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { if (dos != null) dos.close(); } catch (IOException e) { ; }
		}
		File file = new File("data2.dat");
		System.out.println(file.getName() + "의 크기는 " + file.length() + "Byte");
		// 객체 타입에 맞게 읽기
		try (ObjectInputStream dis = new ObjectInputStream(new FileInputStream("data2.dat"))) {
			byte b = dis.readByte();
			System.out.println("b = " + b);
	
			int i = dis.readInt();
			System.out.println("i = " + i);
				
			double d = dis.readDouble();
			System.out.println("d = " + d);
			String s = dis.readUTF();
			System.out.println("s = " + s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
