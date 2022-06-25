<%@page import="kr.green.json.vo.BoxOffice"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String date = request.getParameter("date");
	if(date==null) date = "20210101";
	URL url = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" + date);
	InputStreamReader isr = new InputStreamReader(url.openStream());
	Gson gson = new Gson();
	BoxOffice boxOffice = gson.fromJson(isr, BoxOffice.class);
	out.println(gson.toJson(boxOffice));
%>
