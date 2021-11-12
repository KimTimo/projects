package kr.green.searches.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class ApiVO {
	
	private String bizesNm; // 업소명 = 스타벅스
	private String brchNm; // 지점명 = 분당미금점
	private String ctprvnNm; // 시도명 = 경기도
	private String signguNm; // 시군구명 = 성남시 분당구
	// private String adongNm; // 행정동명 = OO동
	private String rdnmAdr; // 도로명주소 = 경기 성남시 분당구 돌마로 43 메디파크빌딩 1층

}