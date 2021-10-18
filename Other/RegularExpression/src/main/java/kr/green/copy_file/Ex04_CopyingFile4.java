package kr.green.copy_file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex04_CopyingFile4 {
	public static void main(String[] args) {
		Path source = Paths.get("src/main/resources/bugs.txt");
		Path dest = Paths.get("data/resources/bugs3.txt");
		makeDrectory("data/resources/");
		
        try (InputStream fis = Files.newInputStream(source);
        	 OutputStream fos = Files.newOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
			e.printStackTrace();
		}	
        File sourceFile = source.toFile();
        File destFile = dest.toFile();
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
