import kr.green.game.CardVO;

public class CardVOTest {
	public static void main(String[] args) {
		for (int i = 0; i < 52; i++) {
			System.out.print(new CardVO(i) + " ");
			if ((i + 1) % 13 == 0)
				System.out.println(); // 줄바꿈
		}
	}

}
