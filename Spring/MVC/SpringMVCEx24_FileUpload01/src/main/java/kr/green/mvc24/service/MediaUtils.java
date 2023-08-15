package kr.green.mvc24.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

// 업로드할 파일의 종류를 걸러줄때 사용할 도움을 주는 클래스
public class MediaUtils {
	// 이미지 파일의 형식을 저장할 변수
	private static Map<String, MediaType> mediaMap;
	
	static {
		mediaMap = new HashMap<>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	
	// MediaType을 리턴해주는 메서드
	public static MediaType getMediaType(String type) {
		return mediaMap.get(type.toUpperCase());
	}
}
