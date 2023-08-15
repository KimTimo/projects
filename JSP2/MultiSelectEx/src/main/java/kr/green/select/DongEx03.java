package kr.green.select;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import kr.green.select.vo.AreaVO;

public class DongEx03 {
	public static void main(String[] args) throws IOException {
		// Text파일을 JSON파일로 변환해보자!!!!
		String filename = "src/main/resources/dong.txt";
		Path path = Paths.get(System.getProperty("user.dir"), filename);
		List<String> allLines = Files.readAllLines(path);
		List<AreaVO> dongList = new ArrayList<>();
		
		for(int i=1;i<allLines.size();i++) {
			String line = allLines.get(i);
			String[] dongArray = line.split("\t");
			AreaVO vo = new AreaVO();
			vo.setCode(dongArray[0]);
			vo.setName(dongArray[1]);
			vo.setUse(dongArray[2].contains("존재"));
			
			dongList.add(vo);
		}
		System.out.println(dongList.size() + "개");
		PrintWriter pw = new PrintWriter("dong.json");
		Gson gson = new Gson();
		gson.toJson(dongList, pw);
		pw.close();
		System.out.println("저장완료");
	}
}
