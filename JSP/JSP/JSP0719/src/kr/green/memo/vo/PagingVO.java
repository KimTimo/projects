package kr.green.memo.vo;
// 제네릭 클래스로 만들자!!!

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagingVO<T> {
	private List<T> list; // 페이징할 객체 리스트!!!
	
	// 내가 아는것과
	private int totalCount; 	// 전체 개수
	private int currentPage; 	// 현재 페이지 번호
	private int pageSize; 		// 한페이지당 글의 개수
	private int blockSize; 		// 페이지 이동에 표시될 페이지 개수
	
	// 내가 모르는것
	// 전체 페이지수 = 
	private int totalPage;
	// 시작 글번호 =
	private int startNo;
	// 끝 글번호 =
	private int endNo;
	// 페이지 시작번호 = 
	private int startPage;
	// 페이지 끝 번호 = 
	private int endPage;
	
	// 내가 아는것 4개는 생성자로 받아서 초기화 한다.
	public PagingVO(int totalCount, int currentPage, int pageSize, int blockSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		
		// 나머지 5개는 계산해서 넣는다.
		calc();
	}

	private void calc() {
		//--------------------------------------------------------------------------------- ===> 여기 추가
		// 넘어온 값의 유효성을 검사한다.
		// 넘어온 값이 이상항 값이면 기본값을 가지게 한다.
		if(currentPage<=0) currentPage = 1;
		if(pageSize<=1) pageSize = 10;
		if(blockSize<=1) blockSize = 10;
		//---------------------------------------------------------------------------------
		// 전체 페이지수 = (전체개수-1)/페이지당 개수 + 1
		totalPage = (totalCount-1)/pageSize + 1;
		//---------------------------------------------------------------------------------  ====> 여기 추가
		// 현재 페이지가 전체 페이지 보다 크다면 무조건 1페이지를 가지게 한다.
		if(currentPage>totalPage) currentPage=1;
		//---------------------------------------------------------------------------------
		// 시작 글번호 = (현재페이지번호-1) * 페이지 사이즈
		startNo = (currentPage-1) * pageSize;
		// 끝 글번호 = 시작글번호 + 페이지사이즈 -1
		endNo = startNo + pageSize - 1;
		// 유효성 검사!!! 마지막 페이지 다를 수 있다.
		// 마지막페이지일 경우 끝번호가 전체 개수보다 클 수 없다.... 보정을 해준다.
		if(endNo >= totalCount) endNo = totalCount-1; 
		
		// 페이지 시작번호 = (현재페이지-1)/표시될 페이지 개수 * 표시될 페이지 개수 + 1;
		startPage = (currentPage-1)/blockSize * blockSize + 1;
		endPage = startPage + blockSize -1;
		// 유효성 검사!!! 마지막 페이지 다를 수 있다.
		// 마지막페이지번호는 전체 페이지보다 클수 없다.
		if(endPage > totalPage) endPage = totalPage; 
	}

	// 아직 list에는 내용이 없다. 리스트를 채워주는 setter가 필요한다.
	public void setList(List<T> list) {
		this.list = list;
	}
	
	// 메서드 추가!!!
	// 페이지 상단의 전체 ??개(?/?Page)를 출력하는 메서드
	public String getPageInfo() {
		String result = "전체 : " + list.size() + "개";
		if(totalCount>0) {
			result += "(" + currentPage + "/" + totalPage + "Page)";
		}
		return result;
	}
	// 페이지 하단에 링크 만들어 주기
	public String getPageList() {
		String result = "";
		if(totalCount>0) {
			if(startPage>1) { // 시작페이지 번호가 1보다 크다는것은 이전이 존재한다.
				result += "[<a href='?p=" + (startPage-1) + "&s=" + pageSize + "&b="+blockSize+"'>이전</a>] ";
			}
			// 페이지 번호 출력 
			for(int i=startPage;i<=endPage;i++) {
				if(currentPage==i) { // 현재 페이지는 링크를 걸지 않는다.
					result += "[" + i +"] ";
				}else {
					result += " [<a href='?p=" + (i) + "&s=" + pageSize + "&b="+blockSize+"'>" + i + "</a>]";
				}
			}
			if(endPage<totalPage) { // 마지막페이지 번호가 전체 페잊 번호보다  적다는 것은 다음이 존재한다.
				result += " [<a href='?p=" + (endPage+1) + "&s=" + pageSize + "&b="+blockSize+"'>다음</a>]";
			}
		}
		return result;
	}
}
