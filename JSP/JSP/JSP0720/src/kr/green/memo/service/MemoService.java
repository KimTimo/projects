package kr.green.memo.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.green.memo.vo.MemoVO;

public class MemoService {
	// 데이터 파일 읽기
	public static List<MemoVO> readMemo(String path) {
		List<MemoVO> list = null;
		try (FileReader fr = new FileReader(path)) {
			Gson gson = new Gson();
			list = gson.fromJson(fr, new TypeToken<List<MemoVO>>() {
			}.getType());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 데이터 파일 저장하기
	public static void saveMemo(String path, List<MemoVO> list) {
		try (PrintWriter pw = new PrintWriter(path)) {
			Gson gson = new Gson();
			gson.toJson(list, pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
