package kr.green.maven0630.vo;

import java.util.List;

import lombok.Data;

/*
boxOfficeResult: {
    boxofficeType: "일별 박스오피스",
    showRange: "20120101~20120101",
    dailyBoxOfficeList: [],
}
 */
@Data
public class BoxOfficeResult {

	private String boxofficeType;
	private String showRange;
	private List<DailyBoxOffice> dailyBoxOfficeList;
}
