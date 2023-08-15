import java.util.Arrays;
import java.util.Random;

public class BubbleSortEx2 {

	public static void main(String[] args) {

		int arr[] = new int[3];
		Random rnd = new Random();
		for (int i = 0; i < arr.length; i++) { // 배열을 1~100 사이의 난수로 초기화
			arr[i] = rnd.nextInt(101);
		}
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		// boublesort는 중간에 정렬을 완료할 수 있다.
		// 오른쪽 데이터 비교하는 1번도 교환이 이루어지지 않았다면 이미 정렬되었다고 가정해도 된다.

		for (int i = 0; i < arr.length - 1; i++) { // 0 ~ n-1회
			boolean flag = true; // ----------------------------------------------> 이미 정렬되었다고 가정
			for (int j = 0; j < arr.length - 1; j++) { // 0 ~ n-1-i회 반복
				// if(arr[j] > arr[j+1]) { // 앞에것이 크면 교환 : 오름차순
				if (arr[j] < arr[j + 1]) { // 뒤의것이 크면 교환 : 내림차순
					// 교환
					int temp = arr[j]; //
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = false; // ---------------------------------------------> 교환이 이루어졌다면 아직 정렬 중이라고 표시
				}
			}
			System.out.println(i + 1 + "회전 : " + Arrays.toString(arr));

			// flag 값이 참이라면 if문에 1번도 들어간적이 없다. 결국 교환이 1번도 이루어지지 않았다. 정렬이 완료되었으므로 시마이!
			if (flag)
				break;
		}
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

}
