package kr.green.poll.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.green.poll.vo.PollVO;

public class PollUtil {
	// 객체마다 저장하는 값이 없고 기능만 있는 클래스들은 정적 메서드로 만들어라
	
	// 지정한 json파일을 읽어서 List<PollVO> 로 리턴하는 메서드
	public static List<PollVO> readPollVO(String fileName) {
		List<PollVO> list = null;
		Gson gson = new Gson();
		try(FileReader fr = new FileReader(fileName)) {
			list = gson.fromJson(fr, new TypeToken<List<PollVO>>() {}.getType());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	// 지정한 List<PollVO>  객체를 지정한 이름으로 저장하는 메서드
	public static void savePollVO(List<PollVO> list, String fileName) {
		Gson gson = new Gson();
		try( PrintWriter pw = new PrintWriter(fileName)) {
			gson.toJson(list, pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
