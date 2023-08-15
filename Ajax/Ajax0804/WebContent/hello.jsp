<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	request.setCharacterEncoding("UTF-8");
	String command = request.getParameter("c");
	if(command==null) command = "";
	SimpleDateFormat sdf = null;
	switch(command){
	case "date":
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		out.println("현재 날짜 : " + sdf.format(new Date()));
		break;
	case "time":
		sdf = new SimpleDateFormat("hh:mm:ss.S");
		out.println("현재 시간 : " + sdf.format(new Date()));
		break;
	case "now":
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		out.println("현재 날짜시간 : " + sdf.format(new Date()));
		break;
	case "name":
		String name = request.getParameter("name");
		if(name==null) name="무명";
		out.println(name + "씨 반갑습니다.");
		break;
	default:
		out.println("알수 없는 명령입니다.");
	}
%>