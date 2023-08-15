package kr.green.copy_file;

import java.io.File;
import java.util.Arrays;

public class MakeDrectoryEx {
	public static void main(String[] args) {
		makeDrectory("data1");
		makeDrectory("data2/f1/f2");
		makeDrectory("data3\\f1\\f2");
		makeDrectory2("data4\\f1\\f2");
		makeDrectory2("data5/f1/f2");
	}
	private static void makeDrectory(String path) {
		String[] paths = null;
		if(path.contains("/")) {
			paths = path.split("/");
		}else if(path.contains("\\")) {
			paths = path.split("\\\\");
		}else {
			paths = new String[1];
			paths[0] = path;
		}
		System.out.println(Arrays.toString(paths));
		String tempPath="";
		for(int i=0;i<paths.length;i++) {
			tempPath += paths[i];
			File file = new File(tempPath);
			if(!file.exists()) {
				file.mkdir();
			}
			tempPath += File.separator;
		}
	}
	private static void makeDrectory2(String path) {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
}
