
// 자바스크립트 replaceAll 함수 : 문자열, 찾는문자열, 바꿀문자열
function replaceAll(str, searchStr, replaceStr) {
	return str.split(searchStr).join(replaceStr);
}
// <br>을 줄바꿈 문자로 바꾸는 함수
function br2nl(str, replaceMode) {
	var replaceStr = (replaceMode) ? "\n" : '';
	// Includes <br>, <BR>, <br />, </br>
	return str.replace(/<\s*\/?br\s*[\/]?>/gi, replaceStr);
}

// 줄바꿈 문자를 <br>로 만드는 함수
function nl2br(str, replaceMode, isXhtml) {
	var breakTag = (isXhtml) ? '<br />' : '<br>';
	var replaceStr = (replaceMode) ? '$1' + breakTag : '$1' + breakTag + '$2';
	return (str + '').replace(/([^>\r\n]?)(\r\n|\n\r|\r|\n)/g, replaceStr);
}
/**
 * 스크립트 기반 POST 전송
 * @param action - URL
 * @param params - JSON
 * @returns
 */
function sendPost(action, params) {
	var form = document.createElement('form');
	form.setAttribute('method', 'post');
	form.setAttribute('action', action);
	document.charset = "utf-8";
	for ( var key in params) {
		var hiddenField = document.createElement('input');
		hiddenField.setAttribute('type', 'hidden');
		hiddenField.setAttribute('name', key);
		hiddenField.setAttribute('value', params[key]);
		form.appendChild(hiddenField);
	}
	document.body.appendChild(form);
	form.submit();
}
