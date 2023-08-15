import java.util.Arrays;
import java.util.Random;

/*
 * 문제 : 배열의 내용을 뒤집어라.
 */
public class ArrayEx08 {

	public static void main(String[] args) {
		int arr[] = new int[10];
		Random rnd = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(101)+1;
		}
		System.out.println("원본 : " + Arrays.toString(arr));
		int temp[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			temp[arr.length-i-1] = arr[i];
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
		System.out.println("뒤집기 후 : " + Arrays.toString(arr));
		// -------------------------------------------------------
		for(int i = 0; i < arr.length/2; i++) {
			// 교환
			int t = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = t;
		}
		// -------------------------------------------------------
		System.out.println("뒤집기 후 : " + Arrays.toString(arr));
	} // close main

} // close class
