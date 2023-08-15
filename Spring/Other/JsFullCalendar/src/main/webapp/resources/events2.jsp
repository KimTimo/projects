<%@page import="com.google.gson.Gson"%>
<%@page import="kr.green.calendar.util.EventUtil"%>
<%@page import="kr.green.calendar.vo.EventVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	List<EventVO> list = EventUtil.readEvents(application.getRealPath("/resources/"));
	Gson gson = new Gson();
	out.println(gson.toJson(list));
%>
