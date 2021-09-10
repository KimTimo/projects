package kr.green.maven0630.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import kr.green.maven0630.vo.ChunjaVO;

public class Ex_Gson3 {
	public static void main(String[] args) {
		// 사용자가 만든 클래스도 json 으로 상호 변환이 가능할까?
		Gson gson = new Gson();

		// chunja.json 파일을 읽어서 자바 객체로 만들자!
		try {
			// ChunjaVO 의 배열로 읽었다.
			ChunjaVO[] data = gson.fromJson(new FileReader("src/main/resources/chunja.json"), ChunjaVO[].class);
			
			System.out.println(data.length + "개");
			for(ChunjaVO vo : data) {
				System.out.println(vo.getIdx() + ". " + vo.getH() + "(" + vo.getM1() + ")");
			}
			
			// ChunjaVO 의 리스트로 읽었다.
			List<ChunjaVO> list = gson.fromJson(new FileReader("src/main/resources/chunja.json"), new TypeToken<List<ChunjaVO>>() {}.getType());
			System.out.println(list.size() + "개를 리스트로 읽음");
			
			// 저장 가능?
			gson.toJson(list, new FileWriter("hanja.json"));
			
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
