package kr.green.poll.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import kr.green.poll.vo.PollVO;

public class PollUtil {
	
	// 객체마다 저장하는 값이 없고 기능만 있는 클래스들은 정적 메서드로 만들어라
	public static PollVO readPollVO(String fileName) {
		PollVO vo = null;
		Gson gson = new Gson();
		try(FileReader fr = new FileReader(fileName)) {
			vo = gson.fromJson(fr, PollVO.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		return vo;
	}

	// 지정한 json 파일을 읽어서 PollVO로 리턴하는 메소드
	public static void savePollVO (PollVO vo, String fileName) {
		Gson gson = new Gson();
		try(PrintWriter pw = new PrintWriter(fileName)) {
			gson.toJson(vo, pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
