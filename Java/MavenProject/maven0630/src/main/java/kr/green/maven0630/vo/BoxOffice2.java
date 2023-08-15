package kr.green.maven0630.vo;

import java.util.List;

import lombok.Data;
// 사용되는 클래스들을 내부 클래스로 만든 경우

@Data
public class BoxOffice2 {

	private BoxOfficeResult boxOfficeResult;

	@Data
	public class BoxOfficeResult {
		private String boxofficeType;
		private String showRange;
		private List<DailyBoxOffice> dailyBoxOfficeList;

		@Data
		public class DailyBoxOffice {
			private String rank;
			private String movieNm;
			private String openDt;
		}
	}

}
