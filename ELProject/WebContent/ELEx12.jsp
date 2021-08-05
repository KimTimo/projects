<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>EL(Expression Language) Example 17</title>
</head>
<body>
	<h1>EL(Expression Language) Example</h1>
	<hr>
	EL(Expression Language)에서 $와 #의 차이점
	<br> $는 변수에 값이 할당될때 값이 결정되고 #은 변수의 사용시점에서 값이 결정된다.
	<br>
	<%-- Person person = new Person() --%>
	<jsp:useBean id="person" class="kr.green.el.Person" scope="request" />
	<%-- Setter를 EL에서 호출 --%>
	${person.setIdx(1) } ${person.setName('한사람') } ${person.setAge(18) }
	${person.setWeight(55.5) } ${person.setHeight(178.5) }
	<%-- 출력 --%>
	${person.person }
	<br>
	<%-- 변수 생성 :  하나는 $ 하나는 #으로 만들었다. --%>
	<c:set var="weight1" value="${person.weight}" /> <%-- $는 여기에서 값이 결정된다. 다시 할당하기 전까지는 바뀌는 않는다. --%>
	<c:set var="weight2" value="#{person.weight}" />
	<br>
	<hr>
	몸무게 변화 관찰
	<%-- 처음은 두개 값이 같다. --%>
	<br> ${person.name }님 : ${weight1}Kg ▶▶▶▶ ${weight2 }Kg <%-- #은 여기에서(사용시점) 값이 결정된다. --%>
	<br> 
	<%-- 값 변경 후 출력 : $로 만든 변수는 값이 변하지 않지만 #으로 만든 변수는 값이 변경된다. --%>
	${person.setWeight(58.7) } 
	${person.name }님 : ${weight1}Kg  ▶▶▶▶ ${weight2 }Kg <%-- #은 여기에서(사용시점) 값이 결정된다. --%>
	<%-- 값 변경 후 출력 --%>
	<br> ${person.setWeight(63.9) } 
	${person.name }님 : ${weight1}Kg  ▶▶▶▶ ${weight2 }Kg <%-- #은 여기에서(사용시점) 값이 결정된다. --%>
	<br>
</body>
</html>