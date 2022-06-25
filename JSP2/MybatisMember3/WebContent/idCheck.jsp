<%@page import="kr.green.member.service.MemberService"%>
<%@ page contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 아이디 중복확인하기 --%>
<%
	String userid = request.getParameter("userid");
	int count = MemberService.getInstance().idCheck(userid);
	out.println(count);
%>