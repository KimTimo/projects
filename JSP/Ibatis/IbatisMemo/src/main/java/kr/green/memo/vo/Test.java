package kr.green.memo.vo;

public class Test {
	public static void main(String[] args) {
		PagingVO<String> pagingVO = new PagingVO<String>(4, 10, 10, 236);
		System.out.println(pagingVO);
		System.out.println(pagingVO.getPageInfo());
		System.out.println(pagingVO.getPageList());

		pagingVO = new PagingVO<String>(23, 10, 10, 236);
		System.out.println(pagingVO);
		System.out.println(pagingVO.getPageInfo());
		System.out.println(pagingVO.getPageList());
	}

}
