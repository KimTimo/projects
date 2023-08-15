/*
시저 암호는, 고대 로마의 황제 줄리어스 시저가 만들어 낸 암호인데, 예를 들어 알파벳 A를 입력했을 때,
그 알파벳의 n개 뒤에 오는(여기서는 예를 들 때 3으로 지정하였다)알파벳이 출력되는 것이다. 
예를 들어 바꾸려는 단어가 'CAT"고, n을 5로 지정하였을 때 "HFY"가 되는 것이다.
어떠한 암호를 만들 문장과 n을 입력했을 때 암호를 만들어 출력하는 프로그램을 작성해라.
Z댜음에는 다시 A로 돌아온다.
 */
public class Ex02 {

	public static void main(String[] args) {
		// 'ABCD' 10번 반복 
		for(int i = 0; i < 40; i++) {
			System.out.print((char)('A'+i%4));
		}
		System.out.println();
		
		// 4567을 10번 반복
		for(int i = 0; i < 40; i++) {
			System.out.print((i%4+4));
		}
		System.out.println();

		/*
		 * System.out.println((char)('C' + 5)); System.out.println((char)('A' + 5));
		 * System.out.println((char)('T' + 5));
		 */
		System.out.println();
		System.out.println(getPassword("CAT", 5));
		System.out.println(getPassword("CAT", 6));
		System.out.println(getPassword("CAT", 8));
	}

	public static String getPassword(String str, int key) {
		String password = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); // 한글자 잘라내는 메소드
			// 변경
			ch = (char)('A' + ((ch + key) - 'A') % 26);
			// ((ch + key)-'A') : A로 부터 떨어진 간격
			// ((ch + key)-'A')%26) : 알파벳이 26자이다. 그럼 A에 0~25사이의 숫자를 더하면 된다.
			password += ch;
		}

		return password;
	}

}
