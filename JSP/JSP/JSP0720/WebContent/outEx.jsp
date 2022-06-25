<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 객체</title>
</head>
<body>
	<%
        String name = request.getParameter("name");
    if(name==null || name.trim().length()==0){
    	name = "무명";
    }
    //int age = Integer.parseInt(request.getParameter("age"));
    int age = 0;
    try{
    	age = Integer.parseInt(request.getParameter("age"));
    }catch(Exception e){
    	;
    }
    	out.println(name + "씨 " + age + "살이네요?");
    	out.newLine();
    if(age < 18){
    	out.println("호홋 아직 어리시네요 여기에 계시면 안됨다");
    }else{
    	out.println("어른이시군요 즐기시다 가십셔!");    	
    }
    out.newLine();
    out.newLine();
    out.print("하");
    out.print("하");
    out.print("하");
    out.println("하");
    out.println("하");
    out.println("하");
    %>
	<hr />
	<%
    if(age<18){
    %>
        당신은 너무 젊어서 아니되오.
    <%
    }else{
    %>
        어른이시군요 즐기시다 가세요~
    <%
    }
    %>

</body>
</html>