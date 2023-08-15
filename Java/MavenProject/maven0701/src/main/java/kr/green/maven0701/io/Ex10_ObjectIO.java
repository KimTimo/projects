package kr.green.maven0701.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex10_ObjectIO {
	public static void main(String[] args) {
		ObjectOutputStream dos = null;
		// 희소배열(sparse array)(의미있는 데이터가 희박하게 분포된 배열)을 직렬화 하는 경우
		try {
			dos = new ObjectOutputStream(new FileOutputStream("data7.dat"));
			DistrChart2 chart = new DistrChart2();
			chart.arr[1][1] = 34;
			chart.arr[4][5] = 21;
			chart.arr[7][8] = 62;
			chart.arr[9][9] = 77;
			chart.arr[5][3] = 32;
			// 배열 출력
			for(int i=0;i<chart.arr.length;i++) {
				for(int j=0;j<chart.arr[i].length;j++) {
					System.out.printf("%3d", chart.arr[i][j]);
				}
				System.out.println();
			}
			// 희소 배열을 직렬화/역직렬화 메서드를 구현해서 저장!!!
			dos.writeObject(chart);
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { if (dos != null) dos.close(); } catch (IOException e) { ; }
		}
		File file = new File("data7.dat");
		System.out.println("저장된 파일의 크기 : " + file.length() + "Byte"); // 129바이트만 (이전에는 602바이트)
		// 희소 배열의 경우 배열의 크기가 크다면 상대적으로 필요없는 저장공간을 낭비한다.
		// 이렇게 낭비되는 공간을 줄이려면 직렬화/역직렬화 메서드를 사용자가 직접 만들어 주면 된다.
	}
}
