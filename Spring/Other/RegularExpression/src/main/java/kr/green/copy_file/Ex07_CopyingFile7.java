package kr.green.copy_file;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;
/*
Java copying file with Guava
pom.xml에 추가
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>28.0-jre</version>
</dependency>
 */
public class Ex07_CopyingFile7 {
	public static void main(String[] args) {
		File source = new File("src/main/resources/bugs.txt");
		makeDrectory("data/resources/");
		File dest = new File("data/resources/bugs7.txt");
		
		try {
			Files.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File sourceFile = new File("src/main/resources/bugs.txt");
		File destFile = new File("data/resources/bugs7.txt");
        System.out.print(sourceFile.getName() + "(" + sourceFile.length() + "Byte)를 ");
        System.out.println(destFile.getName() + "(" + destFile.length() + "Byte)로 복사완료!!");

	}
	private static void makeDrectory(String path) {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
}
