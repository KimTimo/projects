<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"></jsp:useBean>
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일(E) hh:mm:ss.S"/>