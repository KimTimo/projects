package kr.green.mvc24.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileService {
	
	// 파일이 많을 경우 "upload/년/월/일/저장파일" 형태로 저장하기 위하여 
	// 날짜별로 폴더를 만들어 주는 메서드
	private static String makePath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		// /0000
		String yearPath = File.separator + String.format("%04d", cal.get(Calendar.YEAR));
		// /0000/00
		String monthPath = yearPath + File.separator + String.format("%02d", cal.get(Calendar.MONTH)+1);
		// /0000/00/00
		String datePath = monthPath + File.separator + String.format("%02d", cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		log.info("만들어진 경로 : {}", datePath);
		return datePath;
	}

	private static void makeDir(String uploadPath, String... paths) {
		// 이미 폴더가 만들어져 있다면 아무짓도 하지 않겠다.
		if(new File(uploadPath + paths[paths.length-1]).exists()) return;
		// 년/월/일 폴더를 생성한다.
		for(String path : paths) {
			File file = new File(uploadPath + path);
			if(!file.exists()) file.mkdir(); // 폴더가 존재하지 않으면 폴더 생성
		}
	}
	
	// 완성된 파일이름을 만들어 주는 메서드
	private static String makeFilename(String uploadPth, String path, String filename) {
		log.info("FileService makeFilename 리턴값 : {}", uploadPth + path + File.separator + filename );
		return uploadPth + path + File.separator + filename;
	}
	
	// 이미지 파일일 경우 썸네일 이미지를 생성해 주는 메서드
	private static String makeThumbnail(String uploadPth, String path, String filename) throws IOException {
		// 1. 이미지 파일을 읽는다.
		BufferedImage sourceImage = ImageIO.read(new File(uploadPth + path, filename));
		// 2. 썸네일 이미지를 만든다.
		BufferedImage destImage = Scalr.resize(sourceImage, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		// 3. 썸네일 이미지 이름을 만든다.
		String thumbnailName = uploadPth + path + File.separator + "s_" + filename;
		// 4. 썸네일 이미지 파일을 만든다.
		// 4-1. 파일 객체 생성	
		File newFile = new File(thumbnailName);
		// 4-2. 파일 형식 얻기
		String fileFormat = filename.substring(filename.lastIndexOf(".")+1); // 확장자 얻기
		// 4-3. 이미지 파일 저장
		ImageIO.write(destImage, fileFormat.toUpperCase(), newFile);
		// 5. 파일이름을 리턴한다.
		log.info("FileService makeThumbnail 리턴값 : {}", thumbnailName );
		return thumbnailName;
	}
	
	// 업로드 처리를 담당하는 메서드
	public static String uploadFile(String uploadPath, String originalName, byte[] fileDate) throws IOException {
		UUID uuid = UUID.randomUUID(); // 파일이름의 중복을 방지하기위해 겹치지않는 값을 만들어 주는 클래스
		String saveName = uuid.toString() + "_" + originalName; // 뒤에 _원본이름 붙이기
		String savePath = makePath(uploadPath); // /0000/00/00 폴더 만들기
		File   target = new File(uploadPath + File.separator + savePath, saveName); // 저장 파일객체 생성
		FileCopyUtils.copy(fileDate, target); // 파일 복사
		String fileFormat = originalName.substring(originalName.lastIndexOf(".")+1); // 확장자 얻기
		String uploadFilename = "";
		// 이미지 파일이면 썸네일을 생성한다.
		if(MediaUtils.getMediaType(fileFormat)!=null) {
			uploadFilename = makeThumbnail(uploadPath, savePath, saveName);
		}else {
			uploadFilename = makeFilename(uploadPath, savePath, saveName);
		}
		log.info("FileService uploadFile 리턴값 : {}", uploadFilename);
		return uploadFilename;
	}
}
