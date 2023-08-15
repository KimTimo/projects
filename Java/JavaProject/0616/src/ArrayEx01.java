import java.util.Arrays;

/*
 * 배열(Array) : 동일한 타입의 데이터 집합
 * 선언 : 자료형[] 배열명, 자료형 배열명[]
 * 공간확보 : new 자료형[크기]
 */
public class ArrayEx01 {

	public static void main(String[] args) {

		int arr1[]; // 배열명만 선언 -- 실제 배열은 생기지 않았다.
		arr1 = new int[10]; // 정수 10개를 저장할 공간을 확보하고 arr1이 그 공간의 주소를 기억한다.
		
		// 배열은 자동으로 초기화된다.
		System.out.println(Arrays.toString(arr1));
		
		boolean[] arr2 = new boolean[5];
		System.out.println(Arrays.toString(arr2));
		
		String[] names = new String[5];
		System.out.println(Arrays.toString(names));
		
		// 선언과 동시에 초기화 가능
		int score[] = {57,91,62,61,93};
		System.out.println(Arrays.toString(score));
		
		// 선언 후 초기화
		int score2[];
		// score2 = {1,2,3,4,5}; // Error
		score2 = new int[] {11,22,33,44,55,66}; // 이건 가능
		System.out.println(Arrays.toString(score2)); 
		
		System.out.println(score.length + "개");
		System.out.println(score2.length + "개");
		
		// 반복문과 같이 사용 : 배열의 요소에 접근할 때는 "배열명[위치]로 접근한다. 위치는 0~n-1까지이다.
		int sum = 0;
		for(int i = 0; i < score2.length; i++) {
			System.out.println("score2[" + i + "] = " + score2[i]);
			sum += score2[i];
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (double)sum/score2.length);
		
	}

}
