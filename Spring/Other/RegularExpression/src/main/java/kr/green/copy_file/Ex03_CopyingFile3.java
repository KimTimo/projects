package kr.green.copy_file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Ex03_CopyingFile3 {
	public static void main(String[] args) {
		makeDrectory("data/resources");
		try(RandomAccessFile source = new RandomAccessFile("src/main/resources/bugs.txt", "r");
			RandomAccessFile dest = new RandomAccessFile("data/resources/bugs4.txt", "rw");
			FileChannel sfc = source.getChannel();
			FileChannel dfc = dest.getChannel();){
			dfc.transferFrom(sfc, 0, sfc.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		File sourceFile = new File("src/main/resources/bugs.txt");
		File destFile = new File("data/resources/bugs4.txt");
		System.out.print(sourceFile.getName() + "(" + sourceFile.length() + "Byte)를 ");
		System.out.println(destFile.getName() + "(" + destFile.length() + "Byte)로 복사완료!!");
	}

	private static void makeDrectory(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
