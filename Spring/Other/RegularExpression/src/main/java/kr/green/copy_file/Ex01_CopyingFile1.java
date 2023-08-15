package kr.green.copy_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01_CopyingFile1 {
	public static void main(String[] args) {
		String source = "src/main/resources/bugs.txt";
		String dest = "data/resources/bugs2.txt";
		makeDrectory("data/resources/");
		FileInputStream fis =  null;
		FileOutputStream fos = null;
        try {
        	fis =  new FileInputStream(source);
        	fos = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
        File sourceFile = new File(source);
        File destFile = new File(dest);
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
