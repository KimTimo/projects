import java.util.Arrays;
import java.util.Random;

public class BubbleSortEx1 {

	public static void main(String[] args) {

		int arr[] = new int[10];
		Random rnd = new Random();
		for(int i = 0; i < arr.length; i++) { // 배열을 1~100 사이의 난수로 초기화
			arr[i] = rnd.nextInt(101);
		}
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		
		for(int i = 0; i < arr.length-1; i++) { // 0 ~ n-1회
			for(int j = 0; j < arr.length-1; j++) { // 0 ~ n-1-i회 반복
				//if(arr[j] > arr[j+1]) { // 앞에것이 크면 교환 : 오름차순
				if(arr[j] < arr[j+1]) { // 뒤의것이 크면 교환 : 내림차순
					// 교환
					int temp = arr[j]; // 
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println(i + 1 + "회전 : " + Arrays.toString(arr));
		}
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

}
