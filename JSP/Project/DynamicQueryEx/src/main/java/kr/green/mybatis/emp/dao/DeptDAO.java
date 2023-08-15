package kr.green.mybatis.emp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.mybatis.emp.vo.DeptVO;

public class DeptDAO {
	private static DeptDAO instance = new DeptDAO();

	private DeptDAO() {
	}

	public static DeptDAO getInstance() {
		return instance;
	}
	//==================================================================================
	// 부서번호 중복없이
	public List<String> selectDeptID(SqlSession sqlSession){
		return sqlSession.selectList("dept.selectDeptID");
	}
	// JOB 중복없이
	public List<String> selectJobID(SqlSession sqlSession){
		return sqlSession.selectList("dept.selectJobID");
	}
	// 전체
	public List<DeptVO> selectAll(SqlSession sqlSession){
		return sqlSession.selectList("dept.selectAll");
	}
	// 부서별
	public List<DeptVO> selectByDeptID(SqlSession sqlSession, String dept_id){
		return sqlSession.selectList("dept.selectByDeptID", dept_id);
	}
	// 위의 두개를 합치면
	public List<DeptVO> selectDept(SqlSession sqlSession, HashMap<String, String> map){
		return sqlSession.selectList("dept.selectDept", map);
	}
}
