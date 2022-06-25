import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {

		int arr[] = new int[10];
		Random rnd = new Random();
		for(int i = 0; i < arr.length; i++) { // 배열을 1~100 사이의 난수로 초기화
			arr[i] = rnd.nextInt(101)+1;
		}
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		
		for(int i = 0; i < arr.length-1; i++) { // n-1회전 수행
			int k = i; // 현재것을 선택하고
			for(int j = i + 1; j < arr.length; j++) { // 나의 오른쪽부터 끝까지
				// 나보다 적으면 적은 값의 위치를 가진다.
				if(arr[k] > arr[j]) { // 연산자 위치를 바꾸면 내림차순으로 정렬된다.
					k = j; // 적은놈의 위치를 저장한다.
				}
			}
			// 교환
			int temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
			System.out.println(i + 1 + "회전 : " + Arrays.toString(arr));
		}
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

}
