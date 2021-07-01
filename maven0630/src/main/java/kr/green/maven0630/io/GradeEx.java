package kr.green.maven0630.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.green.maven0630.vo.ScoreVO;

public class GradeEx {

	public static void main(String[] args) {
//		ScoreVO vo = new ScoreVO("한사람",55,82,75,68);
//		System.out.println(vo);

		// 데이터를 어디에 저장할까?
		List<ScoreVO> list = new ArrayList<>();

		// 파일을 읽어서 데이터를 만들자
		try (Scanner sc1 = new Scanner(new File("src/main/resources/score.txt"))) {
			while (sc1.hasNextLine()) {
				String line = sc1.nextLine(); // 1줄 읽기
				Scanner sc2 = new Scanner(line); // 읽은 한 줄을 다시 스캐너로 변환
				// 1줄을 분해해서 VO에 넣기
				ScoreVO vo = new ScoreVO();
				vo.setName(sc2.next()); // 이름
				vo.setKor(Integer.parseInt(sc2.next()));
				vo.setEng(Integer.parseInt(sc2.next()));
				vo.setMat(Integer.parseInt(sc2.next()));
				vo.setEdps(Integer.parseInt(sc2.next()));

				list.add(vo); // VO를 리스트에 넣기
			}
			System.out.println("-------------------------------");
			// 출력
			for (ScoreVO vo : list)
				System.out.println(vo);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 석차를 구한다.
		for (ScoreVO vo : list)
			vo.setRank(1); // 모든 석차를 1등으로 만든다.
							// 만약에 석차를 여러번 구하면 계속 누적되므로 초기화가 필요하다.
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getTotal() > list.get(j).getTotal()) {
					list.get(j).setRank(list.get(j).getRank() + 1);
				} else if (list.get(i).getTotal() < list.get(j).getTotal()) {
					list.get(i).setRank(list.get(i).getRank() + 1);
				}
			}
		}
		System.out.println("-----------------------------------------");
		// 출력
		for (ScoreVO vo : list)
			System.out.println(vo);

		// result.txt로 저장한다.
		try (FileWriter fw = new FileWriter("src/main/resources/result.txt")) {

			for (ScoreVO vo : list)
				fw.write(vo.toString() + "\n");
			fw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
