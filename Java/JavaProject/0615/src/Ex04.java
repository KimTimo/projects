
public class Ex04 {

	public static void main(String[] args) {

		int i, j, sw = 1, n; // sw : 반전변수
		i = j = n = 0;
		while (i < 21) { // 줄수
			j = 0;
			while (j <= n) { // 줄당 개수 n까지 출력
				System.out.print("☎");
				j++;
			}
			System.out.println(n);
			n += sw; // 출력할 개수 계산
			if (i == 9)
				sw *= -1; // 가운데 줄에 도착하면 반전
			i++;
		}
		System.out.println();
	}

}
