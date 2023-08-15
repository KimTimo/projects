package kr.green.copy_file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
/*
Java 7 Files.copy()에는 파일을 쉽게 복사할 수 있는 방법이 도입되었습니다 . 
REPLACE_EXISTING옵션을 지정 하지 않으면 대상 파일이 있으면 복사가 실패 합니다. 
Files.copy() 선택적 세 번째 복사 옵션 인수를 취합니다.

options 매개변수에는 다음 중 하나가 포함될 수 있습니다.
REPLACE_EXISTING - 대상 파일이 존재하는 경우 대상 파일이 비어 있지 않은 디렉토리가 아니면 대상 파일이 대체됩니다.
COPY_ATTRIBUTES - 이 파일과 관련된 파일 속성을 대상 파일에 복사하려고 시도합니다.
ATOMIC_MOVE - 파일을 이동합니다.
NOFOLLOW_LINKS - 심볼릭 링크를 따르지 않습니다.
 */
public class Ex05_CopyingFile5 {
	public static void main(String[] args) {
		File source = new File("src/main/resources/bugs.txt");
		makeDrectory("data/resources/");
		File dest = new File("data/resources/bugs5.txt");
		
		try {
			Files.copy(source.toPath(), dest.toPath(),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File sourceFile = new File("src/main/resources/bugs.txt");
		File destFile = new File("data/resources/bugs5.txt");
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
