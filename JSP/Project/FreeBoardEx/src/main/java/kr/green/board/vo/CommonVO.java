package kr.green.board.vo;
// 모든 페이지를 이동할때마다 현재페이지 번호, 페이지당 글의 수, 블록의 수를 가지고 다닌다.
// 이 값을 jsp:useBean태그로 한번에 받기 위한 클래스
public class CommonVO {
	// 받을때 사용할 변수
	private int p; 		// 현재 페이지
	private int s; 		// 페이지당 글의 수
	private int b; 		// 페이지리스트의 페이지 개수
	private int idx; 	// 글번호
	private String m; 	// 글쓰기/수정하기/삭제하기 구분하는 변수
	private boolean h; 	// 조회수 증가 여부
	
	// 실제 사용할 변수
	private int currentPage;
	private int pageSize;
	private int blockSize;
	private String mode;
	private boolean isHit;
	
	public boolean isH() {
		return h;
	}
	public void setH(boolean h) {
		this.h = h;
		this.isHit = this.h;
	}
	public boolean isHit() {
		return isHit;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
		if(this.idx<=0) {
			this.idx = 0;
		}
	}

	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
		if(this.p<=0) {
			this.p = 1; 
		}
		currentPage = this.p;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
		if(this.s<=0) {
			this.s = 5;
		}
		pageSize = this.s;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
		if(this.b<=0) {
			this.b = 5;
		}
		blockSize = this.b; 
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
		if(this.m==null) {
			this.m = "insert";
		}
		if(!this.m.equals("insert") && !this.m.equals("update") && !this.m.equals("delete")&& !this.m.equals("view")) {
			this.m = "insert";
		}
		mode = this.m;
	}
	public String getMode() {
		return mode;
	}
	@Override
	public String toString() {
		return "CommonVO [p=" + p + ", s=" + s + ", b=" + b + ", idx=" + idx + ", m=" + m + ", h=" + h
				+ ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", blockSize=" + blockSize + ", mode="
				+ mode + ", isHit=" + isHit + "]";
	}

}
