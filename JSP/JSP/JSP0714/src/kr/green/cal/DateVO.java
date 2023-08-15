package kr.green.cal;

import lombok.Data;

@Data
public class DateVO {
	private String solar;  // 양력
	private String lunar;  // 음력
	private String gangi;  // 간지(세차 월건 일진)
	
	// 필요한 데이터만 뽑아내는 메서드를 추가하자!!
	// 양력 데이터 분해
	// 1998-05-07 (목)
	public int getSolarYear() { // 양력의 년도만 가져오겠슴
		return Integer.parseInt(solar.split("-")[0]);
	}
	public int getSolarMonth() { // 양력의 월만 가져오겠슴
		return Integer.parseInt(solar.split("-")[1]);
	}
	public int getSolarDate() { // 양력의 일수만 가져오겠슴
		return Integer.parseInt(solar.split("-")[2].split(" ")[0]);
	}
	public String getSolarDayOfWeekStr() { // 양력의 요일을 문자로
		return solar.split("-")[2].split(" ")[1].charAt(1)+"";
	}
	public int getSolarDayOfWeekInt() { // 양력의 요일을 숫자로
		return "일월화수목금토".indexOf(getSolarDayOfWeekStr());
	}
	
	// 음력 데이터 분해
	// 1998-04-12
	public int getLunarYear() { // 음력의 년도만 가져오겠슴
		return Integer.parseInt(lunar.split("-")[0]);
	}
	public int getLunarMonth() { // 음력의 월만 가져오겠슴
		return Integer.parseInt(lunar.split("-")[1]);
	}
	public String getLunarDate() { // 음력의 일수만 가져오겠슴
		return lunar.split("-")[2];
	}
	// 간지 데이터 분해
	// 무인(戊寅)년 정사(丁巳)월 갑인(甲寅)일
	// 윤달의 경우 월건이 없다.
	// 2020-05-23 (토)	2020-04-01 (윤)	경자(庚子)년 병인(丙寅)일
	public String getGangiYearKor() {        // 세차를 한글로
		return gangi.substring(0,2);
	}
	public String getGangiYearHanja() {      // 세차를 한자로
		return gangi.substring(3,5);
	}
	
	public String getGangiMonthKor() {        // 월건을 한글로
		if(gangi.split(" ").length==3)        // 공백으로 나누어 개수가 3이면 월건이 있다.
		    return gangi.split(" ")[1].substring(0, 2);
	    else
	    	return "";
		
	}
	public String getGangiMonthHanja() {      // 월건을 한자로
		if(gangi.split(" ").length==3)        // 공백으로 나누어 개수가 3이면 월건이 있다.
		    return gangi.split(" ")[1].substring(3, 5);
	    else
	    	return "";
	}
	
	public String getGangiDateKor() {        // 일진을 한글로
		if(gangi.split(" ").length==3)        // 공백으로 나누어 개수가 3이면 월건이 있다.
		    return gangi.split(" ")[2].substring(0, 2);
	    else
	    	return gangi.split(" ")[1].substring(0, 2);
		
	}
	public String getGangiDateHanja() {      // 일진을 한자로
		if(gangi.split(" ").length==3)        // 공백으로 나누어 개수가 3이면 월건이 있다.
		    return gangi.split(" ")[2].substring(3, 5);
	    else
	    	return gangi.split(" ")[1].substring(3, 5);
	}

}
