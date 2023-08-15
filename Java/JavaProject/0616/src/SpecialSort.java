import java.util.Arrays;

public class SpecialSort {

	public static void main(String[] args) {

		int arr1[] = {-1, 1, 3, -2, 2, -4, 7, -3, -9};
		int arr2[] = new int[arr1.length];
		int k = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] < 0) arr2[k++] = arr1[i]; 
		}
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] >= 0) arr2[k++] = arr1[i]; 
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

}
