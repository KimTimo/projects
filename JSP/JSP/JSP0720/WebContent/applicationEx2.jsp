<%@page import="java.util.Scanner"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 객체를 이용한 자원 접근하기</title>
<style type="text/css">
    div.out{
        border: 1px solid gray;
        width: 90px;
        height: 70px;
        text-align: center;
        font-size: 25pt;
        float: left;
        margin: 5px;
        padding: 5px;
        background-color: yellow;
        border-radius: 20px;
    }
    div.in{
        border: 1px solid gray;
        width: 82px;
        height: 20px;
        text-align: center;
        font-size: 11pt;
        background-color: skyblue;
        padding: 3px;
        border-radius: 10px;
    }
</style>
</head>
<body>
	<h1>천자문</h1>
	<%
        URL url = application.getResource("chunja.txt");
        Scanner sc = new Scanner(url.openStream(),"UTF-8");
        while(sc.hasNextLine()){
        	String line[] = sc.nextLine().split("\\|");
        	//out.println(line[0] + ". " + line[1] + "(" + line[3] + ")<br>");
        	out.println("<div class='out'>" + line[1]);
        	out.println("<div class='in'>" + line[3]);
        	out.println("</div>");
        	out.println("</div>");
        }
        sc.close();
    %>
    <h1 style="clear: both;">천자문 2</h1>
	<%
    Scanner sc2 = new Scanner(application.getResourceAsStream("chunja2.txt"),"UTF-8");
        while(sc2.hasNextLine()){
        	String line[] = sc2.nextLine().split("\\|");
        	out.println(line[0] + ". " + line[1] + "(" + line[2] + ") : " + line[4] + "<br>");
        }
        sc2.close();
    %>
</body>
</html>