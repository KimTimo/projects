package kr.green.maven0701.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 희소배열(sparse array)(의미있는 데이터가 희박하게 분포된 배열)을 직렬화 하는 경우
public class DistrChart2 implements Serializable {
	int arr[][];

	DistrChart2() {
		arr = new int[10][10];
	}

	// 직렬화/역직렬화 메서드를 사용자가 직접 만들어 주면 된다.
	// 직렬화 메서드
	private void writeObject(ObjectOutputStream out) throws IOException {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] != 0) {
					// arr배열에서 0이 아닌 항들의 값만 행 번호, 열 번호를 함께 출력한다.
					out.writeInt(row);
					out.writeInt(col);
					out.writeInt(arr[row][col]);
				}
			}
		}
	}

	// 역직렬화 메서드
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		arr = new int[10][10]; // 배열 만들고
		try {
			while (true) {
				// 값 3개씩 읽어서
				int row = in.readInt(); // 행
				int col = in.readInt(); // 열
				int data = in.readInt(); // 값
				arr[row][col] = data; // 배열에 넣기
			}
		} catch (EOFException eofe) { // EOF(End Of File) : 파일의 끝
			// eofe.printStackTrace();
		}
	}
}
