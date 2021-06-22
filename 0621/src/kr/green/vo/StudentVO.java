package kr.green.vo;

public class StudentVO {
	private String stuNo; // 학번
	private String name; // 이름
	private int kor, eng, mat, edps; // 국어, 영어, 수학, 전산
	private int rank; // 석차
	// 합계 평균은 어디감? ===> 계선해서 알 수 있는 데이터는 굳이 저장할 필요가 없다. (데이터낭비)

	// 1. 생성자 생성
	public StudentVO(String stuNo, String name) {
		super();
		this.stuNo = stuNo;
		this.name = name;
	}

	public StudentVO(String stuNo, String name, int kor, int eng, int mat, int edps) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.kor = kor >= 0 && kor <= 100 ? kor : 0;
		this.eng = eng >= 0 && eng <= 100 ? eng : 0;
		this.mat = mat >= 0 && mat <= 100 ? mat : 0;
		this.edps = edps >= 0 && edps <= 100 ? edps : 0;
		this.rank = 1;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor >= 0 && kor <= 100 ? kor : 0;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng >= 0 && eng <= 100 ? eng : 0;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat >= 0 && mat <= 100 ? mat : 0;
	}

	public int getEdps() {
		return edps;
	}

	public void setEdps(int edps) {
		this.edps = edps >= 0 && edps <= 100 ? edps : 0;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getStuNo() {
		return stuNo;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%6s %6s %5d %5d %5d %5d %5d %7.2f %5d", stuNo, name, kor, eng, mat, edps, getTotal(),
				getAvg(), rank);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edps;
		result = prime * result + eng;
		result = prime * result + kor;
		result = prime * result + mat;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rank;
		result = prime * result + ((stuNo == null) ? 0 : stuNo.hashCode());
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
		StudentVO other = (StudentVO) obj;
		if (edps != other.edps)
			return false;
		if (eng != other.eng)
			return false;
		if (kor != other.kor)
			return false;
		if (mat != other.mat)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rank != other.rank)
			return false;
		if (stuNo == null) {
			if (other.stuNo != null)
				return false;
		} else if (!stuNo.equals(other.stuNo))
			return false;
		return true;
	}

	// 다른 기능이 필요하면 필요한 기능을 메소드로 구현해준다.
	// 합계
	public int getTotal() {
		return kor + eng + mat + edps;
	}

	// 평균
	public double getAvg() {
		return getTotal() / 4.0;
	}

}
