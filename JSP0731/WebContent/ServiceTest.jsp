<%@page import="kr.green.memo.service.MemoService"%>
<%@page import="kr.green.memo.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 테스트</title>
</head>
<body>
	<%
	// 목록보기 테스트
	List<MemoVO> list = MemoService.getInstance().selectList();
	out.println("전체 : " + list.size() + "개의 글이 있습니다.<br>");
	for (MemoVO vo : list) {
		out.println(vo.toString() + "<br>");
	}

	MemoVO vo = new MemoVO();
	vo.setName("몽돌수정");
	vo.setPassword("1234");
	vo.setContent("나는 몽돌이에용!");
	vo.setIp(request.getRemoteAddr());
	// 모든 내용이 있으니 저장 성공이 나와야함
	if (MemoService.getInstance().insert(vo) > 0) {
		out.println("<script>alert('저장성공몽');</script>");
	} else {
		out.println("<script>alert('저장실패몽');</script>");
	}
	// 이름이 없으니 저장실패해야함
	vo.setName("");
	if (MemoService.getInstance().insert(vo) > 0) {
		out.println("<script>alert('저장성공몽');</script>");
	} else {
		out.println("<script>alert('저장실패몽');</script>");
	}
	out.println("<hr>");
	list = MemoService.getInstance().selectList();
	out.println("전체 : " + list.size() + "개의 글이 있습니다.<br>");
	for (MemoVO v : list) {
		out.println(v.toString() + "<br>");
	}

	// 수정 테스트
	vo = MemoService.getInstance().selectByIdx(2);
	if (vo != null) {
		out.println("<script>alert('수정에 성공했습니다.');</script>");
	} else {
		// 비밀번호가 같으므로 수정에 성공해야함.
		vo.setContent("몽돌 몽돌 몽돌이! 쨔몬 쨔몽!!");
		if (MemoService.getInstance().update(vo) > 0) {
			out.println("<script>alert('수정성공몽');</script>");
		} else {
			out.println("<script>alert('수정실패몽');</script>");
		}
		// 비밀번호가 틀리므로 수정에 실패해야함.
		vo.setContent("몽돌 몽돌 몽돌이! 쨔몬 쨔몽~~~~~~~~");
		vo.setPassword("qwerty");
		if (MemoService.getInstance().update(vo) > 0) {
			out.println("<script>alert('수정성공몽');</script>");
		} else {
			out.println("<script>alert('수정실패몽');</script>");
		}
		out.println("<hr>");
		list = MemoService.getInstance().selectList();
		out.println("전체 : " + list.size() + "개의 글이 있습니다.<br>");
		for (MemoVO v : list) {
			out.println(v.toString() + "<br>");
		}
	}

	// 삭제 테스트!!
	vo.setIdx(1);
	vo.setPassword("12345");
	// 비밀번호가 틀리므로 수정에 실패해야함.
	if (MemoService.getInstance().delete(vo) > 0) {
		out.println("<script>alert('삭제성공몽');</script>");
	} else {
		out.println("<script>alert('삭제실패몽');</script>");
	}
	vo.setPassword("1234");
	if (MemoService.getInstance().delete(vo) > 0) {
		out.println("<script>alert('삭제성공몽');</script>");
	} else {
		out.println("<script>alert('삭제실패몽');</script>");
	}
	out.println("<hr>");
	list = MemoService.getInstance().selectList();
	out.println("전체 : " + list.size() + "개의 글이 있습니다.<br>");
	for (MemoVO v : list) {
		out.println(v.toString() + "<br>");
	}
	%>

</body>
</html>