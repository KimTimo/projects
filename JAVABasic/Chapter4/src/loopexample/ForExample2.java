package loopexample;

public class ForExample2 {

	public static void main(String[] args) {

		int gugu;
		int dan;
		
		for(gugu = 2; gugu <= 9; gugu++) {
//			if((gugu % 2) != 0) { // ¦���ܸ� ����ϰ� �ϴ� �ڵ�(Ȧ���� ����)
//				continue;
//			}
			for(dan = 1; dan <= 9; dan++) {
				
				int gugudan = gugu*dan;
				System.out.println(gugu + "X" + dan + "=" + gugudan);
			}
			System.out.println();
		}
	}

}
