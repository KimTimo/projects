<%@ page contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	// 아이디를 받아 DB에 저장되어있는 아이디들 중에 같은 아이디가 있는지 검사하여  결과에 따른 값을 출력해주면된다.
	// 개수를 세서 1 이상이면 있는 아이디이고 0이면 사용가능한 아이디이다.
	
	// 아직 회원관리를 만들지 않았기 때문에 배열에 동일한 아이디가 있는지로 대체를 한다.
	// 1. 회원 테이블이라고 가정
	String[] member = "root,admin,admin1,admin2,root2,administrator,qwerty,asdf,asdfg".split(",");

	// 2. 넘어온 아이디를 받는다.
	String userid = request.getParameter("userid");
	// String sql = "select count(*) from member  where userid='" + userid + "'"; 
	if(userid!=null){
		for(String id : member){
			if(userid.equals(id)){ // 같은 아이디가 있으면
				out.println(1); // 1을 출력하고
				return; // 종료
			}
		}
	}
	out.println(0); // 같은 아이디가 없으면 0을 출력
%>
