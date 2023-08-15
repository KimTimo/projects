package kr.green.maven0628.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListDeleteEx {

	public static void main(String[] args) {
		Random rnd = new Random();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 20; i++)
			list.add(rnd.nextInt(101)); // 난수로 10개 넣기
		
		System.out.println("데이터 : " + list);
		
		// 데이터 중에 50 이상인 데이터를 모두 삭제하라!
		// 아래와 같이 하게되면 50 이상인 수가 연속적으로 나오면 뒤의 숫자가 지워지지 않는다.
		// remove 메소드를 불러서 지우면 index값이 변경된다.
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i)>=50) list.remove(i);
//		}
//		System.out.println("데이터 삭제 후 : " + list);
		// 반복문에서 삭제를 할 경우에는 반드시 뒤에서 부터 처리해야 index값이 변경되지않는다.
		for(int i = list.size()-1; i >= 0; i--) {
			if(list.get(i)>=50) list.remove(i);
		}
		System.out.println("데이터 삭제 후 : " + list);

	}

}
