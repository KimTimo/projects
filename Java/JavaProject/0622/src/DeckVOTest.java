import kr.green.game.DeckVO;

public class DeckVOTest {

	public static void main(String[] args) {
		DeckVO deck1 = new DeckVO(); // 52장 카드묶음
		System.out.println(deck1);
		System.out.println();

		DeckVO deck2 = new DeckVO(2); // 52장 2세트 섞기
		System.out.println(deck2);
		System.out.println();
		
		System.out.println(deck2.nextCard());
		System.out.println(deck2.nextCard());
		System.out.println(deck2.nextCard());
		System.out.println(deck2.nextCard());
	}

}
