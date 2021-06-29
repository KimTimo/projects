package kr.green.maven0628;

import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Lotto {

	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<>();
		Random random = new Random();
		while(lotto.size() < 6) lotto.add(random.nextInt(45)+1);
		System.out.println("자동으로 만든 로또번호 : " + lotto);
		
		
		IntStream.generate(() -> random.nextInt(45) + 1)
		.distinct()
		.limit(6)
		.sorted()
		.forEach(System.out::println);
	}

}
