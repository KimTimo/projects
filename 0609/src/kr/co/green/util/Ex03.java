package kr.co.green.util; // 첫줄은 패키지 명임. 회사 도메인 이름을 .으로 구분해서 역순으로 표시

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TreeSet;

public class Ex03 {

	public static void main(String[] args) {

	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) hh:mm:ss");
		System.out.println(sdf.format(new Date()));
		for(int i = 0; i < 5; i++) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		while(lotto.size() < 6) {
			lotto.add(new Random().nextInt(45)+1);
		}
		System.out.println("김벌처 로또번호 : " + lotto);
		}
	}

}
