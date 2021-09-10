package kr.green.maven0701.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 객체를 입출력하기 : ObjectInputStream, ObjectOutputStream 
//                     사용자가 작성한 클래스도 저장이 될까요?
public class Ex08_ObjectIO {
	public static void main(String[] args) {
		ObjectOutputStream dos = null;
		/*
		// 직렬화 할때 메서드와 정적 변수 그리고 transient예약어가 붙은 변수는 제외된다.
		try {
			dos = new ObjectOutputStream(new FileOutputStream("data5.dat"));
			// 저장
			dos.writeObject(new Data2("한사람", 22));
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { if (dos != null) dos.close(); } catch (IOException e) { ; }
		}
		*/
		// 이전에 저장 했던 결과를 읽을려고 합니다. 
		// 그런데 저장후 원본 파일이 변경되면 읽을 수 있을까?
		try (ObjectInputStream dis = new ObjectInputStream(new FileInputStream("data5.dat"))) {
			// 읽기
			System.out.println("저장된 내용 읽은 결과 : " + (Data2)dis.readObject());	
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
