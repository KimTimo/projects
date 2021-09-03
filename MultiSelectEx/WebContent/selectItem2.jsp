<%@page import="com.google.gson.Gson"%>
<%@page import="kr.green.select.service.SelectService"%>
<%@page import="kr.green.select.vo.AreaVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	// 두번째 아이템을 읽어서 json으로 리턴한다.
	String code = request.getParameter("code");
	// 세종시 문제
	if(code.equals("36")) code = "3611";
	String filename = application.getRealPath("/dong.json");
	List<AreaVO> list = SelectService.getInstance().selectItem2(filename, code);
	Gson gson = new Gson();
	out.println(gson.toJson(list));
%>