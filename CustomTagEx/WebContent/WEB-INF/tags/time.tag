<%@tag import="java.util.Date"%>
<%@tag import="java.text.SimpleDateFormat"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	out.println(sdf.format(new Date()));
%>