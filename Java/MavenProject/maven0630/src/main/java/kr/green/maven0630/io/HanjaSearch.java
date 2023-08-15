package kr.green.maven0630.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import kr.green.maven0630.vo.HanjaVO;

public class HanjaSearch {

	public static void main(String[] args) {
		//List<HanjaVO> list = readHanja();
		//System.out.println(list.size() + "개 있다.");
		//for(HanjaVO vo : list) System.out.println(vo);
		
		Map<String, HanjaVO> map = readHanjaMap();
		System.out.println(map.size() + "개 읽음");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("찾고자 하는 한자를 입력하시오(0은 종료)");
			String search = sc.nextLine();
			if(search.charAt(0)=='0') break;
			
			if(map.containsKey(search)) {
				System.out.println(search + " : " + map.get(search).getIdx() + "." + map.get(search).getM());
			}else {
				System.out.println(search + "는 천자문에 없는 글자입니다.");
			}
		}
		sc.close();
		
		
	}
	// 천자문 파일을 읽어서 리스트로 리턴하는 메소드
	public static List<HanjaVO> readHanja(){
		List<HanjaVO> list = new ArrayList<>();
		
		try(Scanner sc = new Scanner(new File("src/main/resources/chunja.txt"))) {
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] str = line.split("\\|");
				HanjaVO vo = new HanjaVO();
				vo.setIdx(Integer.parseInt(str[0]));
				vo.setH(str[1]);
				vo.setK(str[2]);
				vo.setM(str[3]);
				
				list.add(vo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	// 천자문 파일을 읽어서 맵으로 리턴하는 메소드
	public static Map<String, HanjaVO> readHanjaMap(){
		Map<String, HanjaVO> map = new TreeMap<>();
		
		try(Scanner sc = new Scanner(new File("src/main/resources/chunja.txt"))) {
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] str = line.split("\\|");    // 구분자로 구분하여
				HanjaVO vo = new HanjaVO();
				vo.setIdx(Integer.parseInt(str[0]));
				vo.setH(str[1]);
				vo.setK(str[2]);
				vo.setM(str[3]);
				
				map.put(vo.getH(), vo);      // 맵에 저장 키를 한자로 vo를 값으로 저장
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
