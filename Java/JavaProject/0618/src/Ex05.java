
public class Ex05 {

	public static void main(String[] args) {

		int sec = 0;
		for(int i = 0; i < 24; i++) { // 24시간
			for(int j = 0; j < 60; j++) { // 60분
				String temp = String.format("%02d:%02d", i, j); // 지정모양의 문자열을 만들어준다.
				// 초로 환산하면 총 몇 초(second) 일까요?
				//if(temp.contains("3")) { // 문자열1.contains(문자열2) : 문자열1이 문자열 2를 포함하고 있으면 참! 첫번째 정답.
				if(i % 10 == 3 || i / 10 == 3 || j % 10 == 3 || j / 10 == 3) { // 두번째 정답.
					System.out.println(temp);
					sec += 60; // 분당 60초동안 보인다. 그러므로 60씩 증가
				}
			}
		}
		System.out.println(sec + "초");
	}

}
