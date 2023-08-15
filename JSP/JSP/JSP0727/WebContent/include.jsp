<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 매 페이지 상단에 들어갈 공통적인 코드는 별도의 파일로 만들어놓고 include해서 사용한다.
request.setCharacterEncoding("UTF-8");
// 페이지 이동시 현재체이지, 페이지당 글수, 블록당 페이지 개수를 넘겨받는다.
int currentPage = 1;
try{
	currentPage = Integer.parseInt(request.getParameter("p"));
}catch(Exception e){
	;
}
int pageSize = 10;
try{
	pageSize = Integer.parseInt(request.getParameter("s"));
}catch(Exception e){
	;
}
int blockSize = 10;
try{
	blockSize = Integer.parseInt(request.getParameter("b"));
}catch(Exception e){
	;
}

int idx = 0;
try{
	idx = Integer.parseInt(request.getParameter("idx"));
}catch(Exception e){
	;
}
// 저장/수정/삭제를 알려주는 모드라는 변수
String mode = request.getParameter("m");
if(mode==null || mode.equals("")) mode="i";

%>