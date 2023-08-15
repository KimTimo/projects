import java.util.Arrays;

public class Ex07 {
	public static void main(String[] args) {
		String[] datas = "0123456789 01234 01234567890 6789012345 012322456789".split(" "); // 공백으로 구분해 배열로 만듬
		System.out.println(Arrays.toString(datas)); // 임시출력
		for(String data : datas)
			System.out.println(isDuplicateNumbers(data)); // 중복체크

	}

	public static boolean isDuplicateNumbers(String str) {
		boolean result = false;
		// 넘어온 str을 글자를 기본으로 오름차순한다. 그래서 그 값이 "0123456789"와 같다면 각각 한 번 씩만 사용된 것이다.
		char[] ar = str.toCharArray(); // char 배열로 만든다.
		Arrays.sort(ar); // 정렬하고
		// System.out.println(Arrays.toString(ar)); // 정렬되었는지 출력해본다.
		// char 배열을 String으로 만들어 비교한다.
		str = "";
		for(char ch : ar) str += ch; // 문자(char)를 문자열(String)로 결합
		//System.out.println(str); // String이 되었는지 출력해본다.

		return "0123456789".equals(str);

	}

}
