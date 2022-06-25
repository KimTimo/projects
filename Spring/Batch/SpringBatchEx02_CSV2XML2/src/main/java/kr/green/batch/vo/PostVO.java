package kr.green.batch.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class PostVO {
	// 우편번호| --- 0
	private String zipCode;
	// 우편일련번호| --- 1
	private String zipSeq;
	// 시도| --- 2
	private String sido;
	//시도영문|시군구| --- 4
	private String gungu;
	// 시군구영문|읍면|
	// 읍면영문|도로명코드|
	// 도로명|도로명영문|지하여부|건물번호본번|건물번호부번|건물관리번호|다량배달처명|시군구용건물명|법정동코드|법정동명|리|산여부|지번본번|읍면동일련번호|지번부번

}
