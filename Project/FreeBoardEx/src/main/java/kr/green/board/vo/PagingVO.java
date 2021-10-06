package kr.green.board.vo;
// 어떤 목록이든 페이징하는 방법은 동일하므로 제네릭으로 만들자

import java.util.List;

public class PagingVO<T> {
	// 페이징된 데이터
	private List<T> list;
	
	// 넘겨받을 네가지 변수를 선언한다.
	private int currentPage;	 // 현재 페이지
	private int pageSize;		 // 페이지당 글의 수	
	private int blockSize;		 // 페이지 목록의 페이지 개수
	private int totalCount;		 // 전체 개수
	
	// 계산할 변수를 선언한다.
	private int totalPage;		 // 전체 페이지 수
	private int startNo;		 //	시작 글번호
	private int endNo;			 // 끝 글번호(오라클에서만 사용)
	private int startPage;		 // 시작 페이지 번호
	private int endPage;		 // 끝 페이지 번호
	
	// 4개의 값을 넘겨받는 생성자를 만든다.
	public PagingVO(int currentPage, int pageSize, int blockSize, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		this.totalCount = totalCount;
		// 나머지 변수값을 계산해주는 메서드를 호출하자
		calc();
	}

	private void calc() {
		// 나머지 변수값을 계산
		// 1. 넘어온 값들의 유효성을 검사해 보자
		if(currentPage<=0) currentPage = 1;
		if(pageSize<1) pageSize = 5;
		if(blockSize<1) blockSize = 5;
		if(totalCount<0) totalCount = 0;
		
		// 2. 글의 개수가 0보다 클때만 나머지 값을 계산한다.
		if(totalCount>0) {
			totalPage = (totalCount-1)/pageSize + 1;
			// 현재 페이지가 전체 페이지수 보다 클 수 없다.
			if(currentPage>totalPage) currentPage = 1;
			startNo = (currentPage-1) * pageSize; // 오라클은  + 1을 해주어야 한다.
			endNo = startNo + pageSize - 1;
			// 마지막 번호는 전체 개수를 넘을 수 없다
			if(endNo>=totalCount) endNo = totalCount - 1; // 오라클은  - 1을 해주지 않는다.
			
			startPage = (currentPage-1)/blockSize * blockSize + 1;
			
			endPage = startPage + blockSize - 1;
			// 마지막 페이지 번호는 전체 페이지 수 보다 클 수 없다.
			if(endPage>totalPage) endPage = totalPage;
		}
	}

	// 한번 계산하면 값을 변경할 수 없어야 한다. 그래서 getter만 만든다.
	// 단, list는 넣어주어야 계산이 되므로 list에 한해서 setter를 만들어 준다.
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
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

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	@Override
	public String toString() {
		return "PagingVO [list=" + list + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", blockSize="
				+ blockSize + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", startNo=" + startNo
				+ ", endNo=" + endNo + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	// 몇개의 필요한 메서드를 추가한다.
	// 1. 페이지 상단의 페이지 정보를 출력해주는 메서드
	//    전체 ??개(?/?Page)
	public String getPageInfo() {
		String message = "전체 : " + totalCount + "개";
		if(totalCount>0) {
			message += "(" + currentPage + "/" + totalPage + "Page)";
		}
		return message;
	}
	
	// 2. 페이지 하단의 페이지번호들 출력해주는 메서드
	public String getPageList() {
		String message = "<nav>";
		message += "<ul class='pagination pagination-sm justify-content-center'>";
		// <%-- 이전 : 시작 페이지가 1보다 크다면 이전이 있다 --%>
		if(startPage>1) {
			message += "<li class='page-item'>";
			message += "<a class='page-link' href='#' onclick='SendPost(\"?\",{\"p\":\""+ (startPage-1) +"\",\"s\":\""+pageSize+"\",\"b\":\""+blockSize+"\"})' aria-label='Previous'>";
			message += "<span aria-hidden='true'>&laquo;</span>";
			message += "</a>";
			message += "</li>";
		}
		//  <%-- 페이지 : 시작페이지 번호부터 끝페이지 번호까지 페이지 번호 출력 --%>
		for(int i=startPage;i<=endPage;i++) {
			if(i==currentPage) {
				message += "<li class='page-item active' aria-current='page'><span class='page-link'>" + i + "</span></li>";
			}else {
				message += "<li class='page-item'><a class='page-link' href='#' onclick='SendPost(\"?\",{\"p\":\""+ (i) +"\",\"s\":\""+pageSize+"\",\"b\":\""+blockSize+"\"})'>" + i + "</a></li>";
			}
		}
		// <%-- 다음 : 마지막 페이지가 전체페이지보다 적다면 다음이 있다 --%>
		if(endPage<totalPage) {
			message += "<li class='page-item'>";
			message += "<a class='page-link' href='#' onclick='SendPost(\"?\",{\"p\":\""+ (endPage+1) +"\",\"s\":\""+pageSize+"\",\"b\":\""+blockSize+"\"})' aria-label='Next'>";
			message += "<span aria-hidden='true'>&raquo;</span>";
			message += "</a>";
			message += "</li>";
		}
		message += "</ul>";
		message += "</nav>";
		return message;
	}
}
