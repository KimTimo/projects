package kr.green.select;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.green.select.vo.AreaVO;

public class DongUtil {
	// JSON파일을 읽어 리턴하는 메서드
	public static List<AreaVO> readJson(String filename){
		List<AreaVO> list = null;
		Gson gson = new Gson();
		try(FileReader fr = new FileReader(filename)) {
			list = gson.fromJson(fr, new TypeToken<List<AreaVO>>() {}.getType());			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	// 1차 대항목만 읽어오는 메서드
	public static List<AreaVO> readItem1(String filename){
		List<AreaVO> list = new ArrayList<>();
		for(AreaVO vo : readJson(filename)) {
			if(vo.getCode().contains("00000000") && vo.isUse() || vo.getCode().equals("3611000000")) {
				list.add(vo);
			}
		}
		return list;
	}
	
	// 2차 대항목만 읽어오는 메서드
	public static List<AreaVO> readItem2(String filename, String code){
		List<AreaVO> list = new ArrayList<>();
		for(AreaVO vo : readJson(filename)) {
			if(vo.getCode().startsWith(code) && !vo.getCode().startsWith(code+"00") && vo.getCode().endsWith("000000") && vo.isUse()) {
				list.add(vo);
			}
			// 세종시만 특별 처리
			if(code.equals("3611")) {
				if(vo.getCode().startsWith(code) && !vo.getCode().startsWith(code+"00") && vo.getCode().endsWith("00") && vo.isUse()) {
					list.add(vo);
				}
			}
		}
		return list;
	}
	// 3차 대항목만 읽어오는 메서드
	public static List<AreaVO> readItem3(String filename, String code){
		List<AreaVO> list = new ArrayList<>();
		for(AreaVO vo : readJson(filename)) {
			if(vo.getCode().startsWith(code) && !vo.getCode().startsWith(code+"00") && vo.getCode().endsWith("00") && vo.isUse()) {
				list.add(vo);
			}
		}
		return list;
	}
	// 4차 대항목만 읽어오는 메서드
	public static List<AreaVO> readItem4(String filename, String code){
		List<AreaVO> list = new ArrayList<>();
		for(AreaVO vo : readJson(filename)) {
			if(vo.getCode().startsWith(code) && !vo.getCode().startsWith(code+"00") && vo.isUse()) {
				list.add(vo);
			}
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		List<AreaVO> list = DongUtil.readJson("dong.json");
		System.out.println(list.size() + "개");
		// 1차테스트
		List<AreaVO> listItem = DongUtil.readItem1("dong.json");
		System.out.println(listItem.size() + "개");
		for(AreaVO vo : listItem) {
			System.out.println(vo.getCode() + " : " + vo.getName());
		}
		// 2차 테스트
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("서울");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		listItem = DongUtil.readItem2("dong.json","11");
		System.out.println(listItem.size() + "개");
		for(AreaVO vo : listItem) {
			System.out.println(vo.getCode() + " : " + vo.getName());
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("세종");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		listItem = DongUtil.readItem2("dong.json","3611");
		System.out.println(listItem.size() + "개");
		for(AreaVO vo : listItem) {
			System.out.println(vo.getCode() + " : " + vo.getName());
		}
		System.out.println("3차테스트");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("종로");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		listItem = DongUtil.readItem3("dong.json","1111");
		System.out.println(listItem.size() + "개");
		for(AreaVO vo : listItem) {
			System.out.println(vo.getCode() + " : " + vo.getName());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("을주군");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		listItem = DongUtil.readItem3("dong.json","3171");
		System.out.println(listItem.size() + "개");
		for(AreaVO vo : listItem) {
			System.out.println(vo.getCode() + " : " + vo.getName());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("세종");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		listItem = DongUtil.readItem3("dong.json","3611");
		System.out.println(listItem.size() + "개");
		for(AreaVO vo : listItem) {
			System.out.println(vo.getCode() + " : " + vo.getName());
		}
		
		System.out.println("4차테스트");		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("오남읍");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		listItem = DongUtil.readItem4("dong.json","41360262");
		System.out.println(listItem.size() + "개");
		for(AreaVO vo : listItem) {
			System.out.println(vo.getCode() + " : " + vo.getName());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("백암면");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		listItem = DongUtil.readItem4("dong.json","41461350");
		System.out.println(listItem.size() + "개");
		for(AreaVO vo : listItem) {
			System.out.println(vo.getCode() + " : " + vo.getName());
		}
		
	}
}
