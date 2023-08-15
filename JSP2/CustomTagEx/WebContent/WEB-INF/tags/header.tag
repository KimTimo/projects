<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 태그에 속성값을 지정해 보자 --%>
<%-- title이란 속성은 필수이다. --%>
<%@ attribute name="title" required="true"%>
<%@ attribute name="level" required="false" type="java.lang.Integer"%>
<%
	String tag = "";
	if(level==null) level=0;
	switch(level){
	case 1:
		tag += "<h1>" + title + "</h1>";
		break;
	case 2:
		tag += "<h2>" + title + "</h2>";
		break;
	case 3:
		tag += "<h3>" + title + "</h3>";
		break;
	default:
		tag += "<h3>" + title + "</h3>";
		break;
	}
	out.println(tag);
%>