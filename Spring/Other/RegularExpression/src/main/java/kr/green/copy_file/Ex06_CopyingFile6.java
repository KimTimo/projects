package kr.green.copy_file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
/*
Java Copying file with Apache Commons IO
pom.xml에 추가
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.5</version>
</dependency>
 */
public class Ex06_CopyingFile6 {
	public static void main(String[] args) {
		File source = new File("src/main/resources/bugs.txt");
		makeDrectory("data/resources/");
		File dest = new File("data/resources/bugs6.txt");
		
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File sourceFile = new File("src/main/resources/bugs.txt");
		File destFile = new File("data/resources/bugs6.txt");
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
