package kr.green.memo.vo;

public class Test {
	public static void main(String[] args) {
		PagingVO<String> pagingVO = new PagingVO<>(4, 10, 10, 236);
		System.out.println(pagingVO);
		System.out.println(pagingVO.getPageInfo());
		System.out.println(pagingVO.getPageList());
		
		
		pagingVO = new PagingVO<>(23, 10, 10, 236);
		System.out.println(pagingVO);
		System.out.println(pagingVO.getPageInfo());
		System.out.println(pagingVO.getPageList());
	}

}
