<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="kr.green.json.vo.HanjaVO"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
// 천자문을 읽어 10글자씩 만 json으로 리턴하는 JSP파일
// 페이지를 받자!!!
int p = 1;
try{
	// 받아서 정수로 변환 
	p = Integer.parseInt(request.getParameter("p"));
}catch(Exception e){
	; // 에러가 발생하면 1페이지를 가진다.
}
if(p<1 || p>100) p = 1;
// JSON을 읽자
Gson gson = new Gson();
InputStreamReader isr = new InputStreamReader(application.getResourceAsStream("chunja.json"));
List<HanjaVO> list = gson.fromJson(isr, new TypeToken<List<HanjaVO>>(){}.getType());
// 원하는 부분만 출력하자
// 1 : 0~9, 2 : 10 ~19 .... 100: 990 ~ 999
List<HanjaVO> result = new ArrayList<>();
for(int i=(p-1)*10;i<=(p-1)*10+9;i++){
	result.add(list.get(i));
}
out.println(gson.toJson(result));
%>