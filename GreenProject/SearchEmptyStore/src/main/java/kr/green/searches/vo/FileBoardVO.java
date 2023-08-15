package kr.green.searches.vo;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class FileBoardVO {
	private int 	idx;					//	글번호
	private String 	name;					//	이름	
	private String 	password;				//	비밀번호
	private String 	subject;				//	제목
	private String 	content;				//	내용
	private Date 	regDate;				//	등록일자
	private String 	ip;						//	아이피
	// 첨부파일의 정보를 저장할 필드 추가
	private List<FileBoardFileVO> fileList;	//	파일정보
	
}