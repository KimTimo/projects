package kr.green.maven0629.exam;

public class Ex04 {
	public static void main(String[] args) {
		System.out.println(diagonalLength(1, 2));
		System.out.println(diagonalLength(3, 4));

	}

	public static double diagonalLength(int x, int y) {
		// Math.sqrt() : 루트값을 구해준다.
		// Mate.pow(x,y) : x의 y승을 구해준다.
		return Math.sqrt(Math.pow(x, 2) + y*y);
	}

}
