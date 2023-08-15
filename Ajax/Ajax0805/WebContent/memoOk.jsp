<%@page import="java.util.Collections"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	if(!request.getMethod().equals("POST")){
		out.println("{\"result\": 0}");
		return;
	}
	String m = request.getParameter("data");
	if(m!=null && m.trim().length()>0){
		List<String> list = null;
		if(session.getAttribute("memo")!=null){
			list = (List<String>)session.getAttribute("memo");
		}else{
			list = new ArrayList<>();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		m = sdf.format(new Date()) + " : " + m;
		list.add(m);
		list.sort(Collections.reverseOrder());
		// System.out.println("목록 : " + list);
		session.setAttribute("memo", list);
		Gson gson = new Gson();
		out.println("{\"result\": 1, \"list\": " + gson.toJson(list) + " }");
		// System.out.println("결과 : {\"result\": 1, \"list\": " + gson.toJson(list) + " }");
	}else{
		out.println("{\"result\": 0}");
	}
%>
