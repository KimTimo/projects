package arrayexample;

public class ArrayExample2 {

	public static void main(String[] args) {
		int[][] array4 = new int[3][4];
		array4[0][1] = 10;
		
		int[][] array5 = new int[3][];
		array5[0] = new int[1];
		array5[0][0] = 10;
		
		int[][] array6 = {{1},{1,2},{1,2,3}};
		
		System.out.println(array6[0][0]);
		
		System.out.println(array6[1][1]);
		
		System.out.println(array6[2][1]);
		

	}

}
