package kr.green.maven0630.vo;

import lombok.Data;

/*
{
	rnum: "1",
	rank: "1",
	rankInten: "0",
	rankOldAndNew: "OLD",
	movieCd: "20112207",
	movieNm: "미션임파서블:고스트프로토콜",
	openDt: "2011-12-15",
	salesAmt: "2776060500",
	salesShare: "36.3",
	salesInten: "-415699000",
	salesChange: "-13",
	salesAcc: "40541108500",
	audiCnt: "353274",
	audiInten: "-60106",
	audiChange: "-14.5",
	audiAcc: "5328435",
	scrnCnt: "697",
	showCnt: "3223",
},
 */
@Data
public class DailyBoxOffice {
	private String rank;
	private String movieNm;
	private String openDt;
}
