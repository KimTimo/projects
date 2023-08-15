<%@page import="java.util.List"%>
<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 데이터를 받는다.
// POST 전송일 경우에만 어떤 일을 한다.
if (!request.getMethod().equals("POST")) {
	// POST전송이 아니라면 누군가가 이 파일을 직접 실행한 것이다.
	// 이때는 처리를 하지않고 투표하기 폼으로 보내버린다.
	response.sendRedirect("list.jsp");
	return;
}

// 값을 받아 정수로 변환한다....
int item = Integer.parseInt(request.getParameter("item"));

//----------------------------------------------------------
// 이 부분 추가
int idx = 0;
try {
	idx = Integer.parseInt(request.getParameter("idx"));
} catch (Exception e) {
	;
}

//----------------------------------------------------------
// 투표한 번호의 숫자를 1 증가 시키고 다시 저장한다.
// 1. 파일 절대 경로 구하기
String fileName = application.getRealPath("/poll.json"); // ====> 수정
// 2. 읽기
List<PollVO> list = PollUtil.readPollVO(fileName);
PollVO vo = list.get(idx);
// 3. 항목 증가
vo.getResult().set(idx, vo.getResult().get(item)+1); // ==> 원래 위치의 값을 읽어서 +1 한 후 다시 저장
// 4. 저장
PollUtil.savePollVO(list, fileName);
// 5. 결과보기로 이동하기
response.sendRedirect("pollResult.jsp?idx=" + idx); // ====> 수정
%>
