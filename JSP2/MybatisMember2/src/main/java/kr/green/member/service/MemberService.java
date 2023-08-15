package kr.green.member.service;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import kr.green.email.util.MailVO;
import kr.green.email.util.SendMail;
import kr.green.member.dao.MemberDAO;
import kr.green.member.vo.MemberVO;
import kr.green.mybatis.MybatisApp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberService {
	private static MemberService instance = new MemberService();
	private MemberService() {}
	public static MemberService getInstance() { return instance; }
	//----------------------------------------------------------------
	
	// 1. 관리자만 전체 목록 확인가능
	public List<MemberVO> selectList(){
		log.debug("selectList() 호출");
		List<MemberVO> memList=null;
		SqlSession sqlSession = null;
		MemberDAO  dao = null;
		// =====================================================================
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = MemberDAO.getInstance();
			// -----------------------------------------------------------------
			memList = dao.selectList(sqlSession);
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================
		return memList;
	}
	// 2. 글번호들을 받아 해당 글번호들의 이메일 주소를 리턴하는 메서드 작성
	public List<String> selectEmail(String idxs){
		log.debug("selectEmail() 인수 : " + idxs);
		List<String> emailList= new ArrayList<>();
		SqlSession sqlSession = null;
		MemberDAO  dao = null;
		// =====================================================================
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = MemberDAO.getInstance();
			// -----------------------------------------------------------------
			for(String i : idxs.split(" ")) {
				int idx = Integer.parseInt(i.trim());
				MemberVO vo = dao.selectByIdx(sqlSession, idx);
				emailList.add(vo.getEmail());
			}
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================
		log.debug("selectEmail() 리턴값 : " + emailList);
		return emailList;
	}
	// 3. 아이디와 비밀번호를 받아 로그인을 처리하는 메서드
	public MemberVO loginCheck(String userid,String password) {
		log.debug("loginCheck() 인수 : {}, {}" , userid, password);
		MemberVO memberVO = null;
		SqlSession sqlSession = null;
		MemberDAO  dao = null;
		// =====================================================================
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = MemberDAO.getInstance();
			// -----------------------------------------------------------------
			// 해당아이디가 있다면
			MemberVO vo = dao.selectByUserid(sqlSession, userid);
			// 비번이 같은지와 현재 사용중인 아이디인지를 검사한다.
			if(vo!=null && vo.getPassword().equals(password) && vo.getUse()==1) {
				memberVO = vo; // 같으면 회원정보를 넣어준다.
			}
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================
		log.debug("loginCheck() 리턴값 : {}" , memberVO);
		return memberVO;
	}
	// 4. 아이디 중복확인하기
	public int idCheck(String userid) {
		log.debug("idCheck() 인수 : {}" , userid);
		int count = 0;
		SqlSession sqlSession = null;
		MemberDAO  dao = null;
		// =====================================================================
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = MemberDAO.getInstance();
			// -----------------------------------------------------------------
			count = dao.countUserID(sqlSession, userid);
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================		
		log.debug("idCheck() 리턴값 : {}" , count);
		return count;
	}
	// 5. 회원 가입
	public void insert(MemberVO mvo) {
		log.debug("insert() 인수 : {}" , mvo);
		SqlSession sqlSession = null;
		MemberDAO  dao = null;
		// =====================================================================
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = MemberDAO.getInstance();
			// -----------------------------------------------------------------
			// 1. 저장을 수행하고
			dao.insert(sqlSession, mvo);
			// 2. 가입축하 이메일 발송
			// 제목
			String subject = mvo.getUsername() + "님 회원가입을 축하합니다.";
			// 내용 : 이것도 함수로 만들어 필요한부분만 변경가능하게 하면된다.
			StringBuffer sb = new StringBuffer();
			sb.append(mvo.getUsername() + "님 회원가입을 축하합니다.<br>");
			sb.append("<a href='http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/MybatisMember/authOk.jsp");
			sb.append("?userid=" + mvo.getUserid() + "&auth=" + mvo.getAuth() + "'>인증</a><br>");
			// 메일발송
			MailVO mailVO = new MailVO();
			mailVO.setFrom("itsungnam202106@gmail.com");
			mailVO.setPassword("woaldjqtek2");
			mailVO.setTo(mvo.getEmail());
			mailVO.setSubject(subject);
			mailVO.setContent(sb.toString());
			SendMail.mailSender(mailVO);
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================		
	}
	// 6. 이메일 인증하기
	public boolean setAuth(MemberVO mvo) {
		log.debug("setAuth() 인수 : {}" , mvo);
		boolean result =false;
		SqlSession sqlSession = null;
		MemberDAO  dao = null;
		// =====================================================================
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = MemberDAO.getInstance();
			// -----------------------------------------------------------------
			// 1. DB에서 해당 아이디의 회원 정보를 가져온다.
			MemberVO memberVO = dao.selectByUserid(sqlSession, mvo.getUserid());
			// 2. 회원정보가 있으면 인증코드가 같은지 비교한다.
			if(memberVO!=null) {
				if(memberVO.getAuth().equals(mvo.getAuth())) {
					// 3. 같다면 인증에 성공
					result = true;
					// 4. use값을 1로 변경해 준다.
					HashMap<String, Integer> map = new HashMap<String, Integer>();
					map.put("use", 1);
					map.put("idx", memberVO.getIdx());
					dao.updateUse(sqlSession, map);
				}
			}
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================			
		log.debug("setAuth() 리턴 : {}" , result);	
		return result;
	}
	
}
