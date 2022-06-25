<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 아이디 자동저장 처리를 위해
    // 저장되어 잇는 아이디를 찾아서 가져오자
    String userid = "";
    // 쿠키에 저장되어 있으면 읽어서 변수에 대입한다.
    Cookie[] cookies = request.getCookies();
    if(cookies!=null && cookies.length>0) { // 쿠키가 null이 아니면서 쿠키가 존재한다면
    	// 쿠키중에 userid가 있는지 찾아서 가져오자
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("userid")){
    			userid = URLDecoder.decode(cookie.getValue(), "UTF-8");
    			break;
    		}
    	}
    }
    // 현재 로그인이 되어있는지 검사를 하자
    boolean isLogin = false;
    if(session.getAttribute("userid")!=null){
    	isLogin = true;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키와 세션을 이용한 로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<style type="text/css">
    fieldset {
	    width: 220px;
	    margin: auto;
	    padding: 15px;
    }
    #userid, #password{
        padding: 5px;
        width: 180px;
        border: 1px solid gray;
        margin-bottom: 5px;
    }
    #submitBtn{
        width: 195px;
        height: 33px;
        margin-top: 5px;
    }
</style>
</head>
<body>
    <% if(isLogin){ // 로그인이 되어 있다면 로그아웃을 보여준다.%>
        <fieldset>
            <legend>로그아웃</legend>
            <div>
                <%=session.getAttribute("userid") %> 님 반갑습니다.<br />
                포인트, 별명등을 출력
            </div>
            <div>
                <input type="button" value="로그아웃" class="btn btn-sm btn-primary submitBtn"onclick="location.href='logout.jsp'"/>
            </div>
        </fieldset>
    <%}else { // 로그인이 되어 있지 않으면 로그인 폼을 보여준다.%>
        <fieldset>
            <legend>로그인</legend>
            <form action="loginOk.jsp" method="post">
                <input type="text" name="userid" id="userid" placeholder="아이디 입력" required="required" value="<%=userid%>"><br />
                <input type="password" name="password" id="password" placeholder="비밀번호 입력" required="required"><br />
                <label>
                    <input type="checkbox" name="saveid" id="saveid" value="1" <%=userid == null || userid.equals("") ? "" : " checked='checked' " %>/>
                    아이디 자동저장
                </label>
                <div>
                    <input type="submit" value="로그인" class="btn btn-sm btn-primary submitBtn" onclick="location.href='logout.jsp'"/>
                </div>
                
            
            
            </form>
        </fieldset>
    <%} %>

</body>
</html>