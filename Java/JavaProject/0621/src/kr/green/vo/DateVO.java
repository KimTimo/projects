package kr.green.vo;

import java.util.Calendar;

public class DateVO {
	// 1. 묶고자하는 변수를 선언한다.
	private int year, month, date; // 필드는 숫자 0, boolean 은 false, 객체는 null 값으로 자동초기화 된다.
	// 데이터는 중요하기 때문에 public으로 외부에서 함부로 접근하게 하면 오동작할 확률이 높아진다.
	// 그래서 외부에 함부로 접근하지 못하도록 private으로 접근을 금지 시키는 것이 좋다. -- 정보의 은폐
	// private은 클래스 내부에서만 사용이 가능하도록 하는 접근 지정자이다.

	// 2. 생성자를 생성한다.
	public DateVO() {
		// 기본 생성자에서는 오늘의 날짜를 가져보자
		Calendar calendar = Calendar.getInstance();
//		int yy = calendar.get(Calendar.YEAR);
//		int mm = calendar.get(Calendar.MONTH)+1;
//		int dd = calendar.get(Calendar.DAY_OF_MONTH);
//		this(yy, mm, dd); // 에러다. this()는 반드시 첫번째 줄에 와야한다.

		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		date = calendar.get(Calendar.DAY_OF_MONTH);
	}

	public DateVO(int year) {
		this(year, 1, 1); // 0이 아닌 초기값이 1로 초기화 되도록 변경
	}

	public DateVO(int year, int month) {
//		super();
//		this.year = year;
//		this.month = month;
		this(year, month, 1);
	}

	public DateVO(int year, int month, int date) {
		super();
		// 값이 유효하지 않으면 현재년, 월, 일을 가지게 해보자. --- 이건 작성자가 알아서 한다.
		Calendar calendar = Calendar.getInstance();
		this.year = year > 0 ? year : calendar.get(Calendar.YEAR);
		this.month = month >= 1 && month <= 12 ? month : calendar.get(Calendar.MONTH) + 1;
		// 유효하지 않은 데이터를 걸러주자
		int m[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		m[1] = (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? 29 : 28;
		int lastDay = m[this.month - 1];

		this.date = date >= 1 && date <= lastDay ? date : calendar.get(Calendar.DAY_OF_MONTH);
	}

	// 3. Getter & Setter를 만든다. ---- 프로퍼티
	// 외부에서 수정이 가능하도록 하려면 setter를 만들어 주고
	// 외부에서 값을 읽도록 하려면 getter를 만들어 준다. --- 업무 분석에 따라서 작성해 주어야 합니다.
	// Getter는 필드 값을 읽는 메소드        :     get필드명
	// Setter는 필드 값을 변경하는 메소드    :     set필드명(변경할 값)
	//                                       :     필드명은 낙타표기법(Cammel)에 따라 첫글자를 대문자로 바꿔서 만든다.
	public void setYear(int year) {
		// 여기에서 유효성 검증도 가능하다.
		Calendar calendar = Calendar.getInstance();
		this.year = year > 0 ? year : calendar.get(Calendar.YEAR);
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		this.month = month >= 1 && month <= 12 ? month : calendar.get(Calendar.MONTH) + 1;	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		Calendar calendar = Calendar.getInstance();
		int m[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		m[1] = (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? 29 : 28;
		int lastDay = m[this.month - 1];
		this.date = date >= 1 && date <= lastDay ? date : calendar.get(Calendar.DAY_OF_MONTH);
	}

	public int getYear() {
		return year;
	}

	// 4. 필요한 메서드를 오버라이딩 한다. 최소 3개
	@Override
	public String toString() {
		return year + "년 " + month + "월 " + date + "일";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + date;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateVO other = (DateVO) obj;
		if (date != other.date)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
}
