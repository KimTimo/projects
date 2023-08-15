<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.green.calendar.util.EventUtil"%>
<%@page import="kr.green.calendar.vo.EventVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	if(name==null || name.trim().length()==0){
		name="모두";
	}
	System.out.println("-------------------------- " + name);
	List<EventVO> list = EventUtil.readEvents(application.getRealPath("/resources/"));
	Gson gson = new Gson();
	List<EventVO> list2 = new ArrayList<>();
	if(name.equals("모두")){
		list2 = list;
	}else{
		for(EventVO vo : list){
			if(vo.getUsername().equals(name)){
				list2.add(vo);
			}
		}
	}
	out.println(gson.toJson(list2));
%>
