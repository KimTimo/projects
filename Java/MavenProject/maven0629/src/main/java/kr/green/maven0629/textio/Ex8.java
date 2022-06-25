package kr.green.maven0629.textio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex8 {
	
	static String path = "src/main/resources/";
	
	public static void main(String[] args) {
		// 텍스트 파일 저장하기
		try(FileWriter fw = new FileWriter(path + "test.txt")){
			
			fw.write("ㄹㅇ됨?\n");
			fw.write("ㄹㅇ?\n");
			fw.write("에이설마\n");
			fw.write("안될듯\n");
			
			fw.flush();   // 버퍼에 남아있는 내용을 저장하고 버퍼를 비워라
			              // 출력버퍼는 꽉 차기 전까지는 저장을 수행하지 않는다.
			System.out.println("저장 완료");
			
			File file = new File(path + "test.txt");
			if(file.exists()) {
				System.out.println(file.getName() + " : " + file.length() + "Byte");
			}else {
				System.out.println("응 없어~");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
