package kr.green.game;

import java.util.Random;

// 카드 1묶음을 가지는 클래스
public class DeckVO {
	private CardVO[] cards; // 카드를 담아놓을 배열
	private int index; // 현재 위치를 저장할 번호

	// 생성자
	public DeckVO() {
		// cards = new CardVO[52];
		this(1); // 1묶음
	}

	public DeckVO(int count) { // 몇개의 카드 묶음을 사용할지 결정
		cards = new CardVO[count * 52]; // 52, 104, 156.....
		shuffle(count); // 섞기
	}

	// 다음 카드를 받는 메소드
	public CardVO nextCard() {
		if (index >= cards.length)
			return null;
		else
			return cards[index++];
	}

	// 카드를 섞어주는 메소드
	private void shuffle(int count) { // 묶음을 받는다
		Random random = new Random();
		int temp;
		for (int i = 0; i < count; i++) { // 묶음만큼 반복
			for (int j = 0; j < 52; j++) { // 0~51까지 넣기
				do {
					temp = random.nextInt(count*52); // 카드 수 범위의 난수를 만든다.
				}while(cards[temp]!=null);           // 그 위치에 카드가 없으면
				cards[temp] = new CardVO(j);         // 카드를 만들어서 넣는다.
			}
		}
	}
	// toString 오버라이딩
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < cards.length; i++) {
			result += cards[i].toString() + " ";
			if((i + 1)% 13 == 0) result += "\n";
		}
		return result;
	}

}
