<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ tag body-content="scriptless" %>
<div style="margin-bottom: 10px;">
	<span style="border: 1px solid gray;width: 300px; padding:5px;margin-right: 10px;">
		<%-- 몸체 내용을 그대로 출력해라 --%>
		<jsp:doBody/>
	</span>
	<%-- 몸체 내용을 변수에 저장해라 --%>
	<jsp:doBody var="content" scope="page"/>
	<span style="border: 1px solid gray;width: 300px; padding:5px;">
		<%--el로 출력 --%>
		${content }
	</span>
</div>


