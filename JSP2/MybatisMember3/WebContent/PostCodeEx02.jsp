<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<!-- 카카오 우편번호를 사용하겠다. 아래의 자바스크립트 라이브러리를 반드시 포함해야 한다. -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function getDaumPostcode() {
        new daum.Postcode({
        	oncomplete: function(data){
        		var zoneCode = data.zonecode; // 우편번호
        		var roadAddr = data.roadAddress; // 도로명 주소 변수
        		var jibunAddr = data.jibunAddress; // 지번주소
        		// alert(roadAddr);
        		$("#postcode").val(zoneCode);
        		$("#roadAddress").val(roadAddr);
        		$("#jibunAddress").val(jibunAddr);
        		$("#detailAddress").focus();
        	}
        }).open();
    }
</script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
<input type="text" name="postcode" id="postcode" placeholder="우편번호" readonly="readonly">
<input type="button" onclick="getDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="roadAddress"  id="roadAddress" placeholder="도로명주소" size="100" readonly="readonly"> <br />
<input type="text" name="jibunAddress"  id="jibunAddress" placeholder="지번명주소" size="100" readonly="readonly"> <br />
<input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소" size="100"><br />
</body>
</html>