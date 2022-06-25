package kr.green.maven0630.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class ScoreVO {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int edps;
	private int rank = 1;
	
	// 생성자 추가
	public ScoreVO(String name, int kor, int eng, int mat, int edps) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.edps = edps;
	}
	

	// 합계
	public int getTotal() {
		return kor + eng + mat + edps;
	}

	public double getAvg() {
		return getTotal() / 4.0;
	}

	@Override
	public String toString() {
		return String.format("%-4s %5d %5d %5d %5d %7.2f %3d", name, kor, eng, mat, edps, getTotal(), getAvg(), rank);
	}


}
