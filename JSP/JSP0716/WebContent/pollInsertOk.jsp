<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 인코딩 지정
request.setCharacterEncoding("UTF-8");
// GET 방식으로 접근을 차단
if (!request.getMethod().equals("POST")) {
	response.sendRedirect("list.jsp");
	return;
}

String title = request.getParameter("title");
String start = request.getParameter("start");
String end = request.getParameter("end");
List<String> item = new ArrayList<>();
String[] items = request.getParameterValues("item");
for (String t : items) {
	if (t != null && t.trim().length() != 0) {
		item.add(t.trim());
	}
}
// item 개수만큼 0으로 채워야한다.
List<Integer> result = new ArrayList<>();
for(int i = 0; i < item.size(); i++)result.add(0);

PollVO vo = new PollVO();
vo.setTitle(title);
vo.setStart(start);
vo.setEnd(end);
vo.setItem(item);
vo.setResult(result);

// 파일에서 읽고
String fileName = application.getRealPath("/poll.json");
List<PollVO> list = PollUtil.readPollVO(fileName);
// 리스트에 vo를 넣고
list.add(vo);
// 다시 저장
PollUtil.savePollVO(list, fileName);

response.sendRedirect("list.jsp");
%>
