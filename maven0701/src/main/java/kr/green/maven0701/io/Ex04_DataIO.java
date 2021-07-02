package kr.green.maven0701.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 데이터 타입에 맞게 입출력하기 : DataInputStream, DataOutputStream 
public class Ex04_DataIO {
	public static void main(String[] args) {
		DataOutputStream dos = null;
		// 데이터 타입에 맞게 저장하기!!!!
		try {
			dos = new DataOutputStream(new FileOutputStream("data.dat"));
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
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e) {
				;
			}
		}
		File file = new File("data.dat");
		System.out.println(file.getName() + "의 크기는 " + file.length() + "Byte");
		// 데이터 타입에 맞게 읽기
		try (DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"))) {
			byte b = dis.readByte();
			System.out.println("b = " + b);
			/*
			// int를 저장 했으니 int로 읽는 것이 맞다. 그런데 다른것으로 읽으면 어떻게 될까요!!! 
			int i = dis.readInt();
			System.out.println("i = " + i);
			*/
			// Int가 4바이트이므로 byte로 읽으면 4번에걸쳐서 읽어야 한다.
			// 이렇게 확인하면 내가 사용하는 시스템이 빅엔디안/리틀엔디안 인지를 판단 할 수 있다.
			// 낮은 번지에 앞자리를 저장하는 방법 : 빅엔디안 --- 윈도우계열
			// 낮은 번지에 뒷자리를 저장하는 방법 : 리틀엔디안 --- 유닉스계열
			System.out.println(Integer.toHexString(dis.readByte()));
			System.out.println(Integer.toHexString(dis.readByte()));
			System.out.println(Integer.toHexString(dis.readByte()));
			System.out.println(Integer.toHexString(dis.readByte()));
			
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
