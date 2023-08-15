//--------------------------------------------------------------------------
// 데이터를 POST로 전송하는 함수
//               (주소, 전달값 JSON, 점송메서드)  
function SendPost(path, params, method) {
    method = method || "post"; // 메서드가 없으면 기본 POST전송
    var form = document.createElement("form"); // 폼태그 생성
    form.setAttribute("method", method); // 메서드를 지정
    form.setAttribute("action", path); // 액션 지정
    // 폼안에 전송된 데이터 만큼 폼태그 작성
    for (var key in params) {
        var hiddenField = document.createElement("input"); // 입력태그
        hiddenField.setAttribute("type", "hidden"); // 숨김
        hiddenField.setAttribute("name", key); // name을 키로
        hiddenField.setAttribute("value", params[key]); // 값을 json의 값으로
        form.appendChild(hiddenField); // 폼에 추가
    }
    document.body.appendChild(form); // 폼을 body에 추가
    form.submit(); // 폼을 전송
}	
// 호출 : sendPost('hanjaList.jsp',{"p":1,"s":10,"b":10},"post");
//--------------------------------------------------------------------------
// 이메일 검증 스크립트
function verifyEmail(emailVal) { 
	var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	// 검증에 사용할 정규식 변수 regExp에 저장 
	return reg_email.test(emailVal);
}
//--------------------------------------------------------------------------
