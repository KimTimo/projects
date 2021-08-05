<%@ page contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	if(session.getAttribute("mv")!=null) {
		session.removeAttribute("mv"); // 세션에 저장된 사용자 정보를 제거한다.
		out.println(1);
		return;
	}
	out.println(0);
%>