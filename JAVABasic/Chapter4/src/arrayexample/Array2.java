package arrayexample;

public class Array2 {

	public static void main(String[] args) {
		int[][] array = { { 1 }, { 10, 20 }, { 100, 200, 300 }, { 1000, 2000, 3000, 4000 } };

		// 2���� �迭 array�� ����մϴ�.
		for (int i = 0; i < array.length; i++) {
			System.out.print((i + 1) + "��° ���� ����մϴ�>");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}
	}
}