package kr.green.member.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
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
}
