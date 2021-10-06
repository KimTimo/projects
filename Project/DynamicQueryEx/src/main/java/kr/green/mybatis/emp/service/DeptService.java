package kr.green.mybatis.emp.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.green.mybatis.MybatisApp;
import kr.green.mybatis.emp.dao.DeptDAO;
import kr.green.mybatis.emp.vo.DeptVO;

public class DeptService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DeptService.class);

	private static DeptService instance = new DeptService();

	private DeptService() {
	}

	public static DeptService getInstance() {
		return instance;
	}
	//==================================================================================
	// 부서번호만
	public List<String> selectDeptID(){
		List<String> deptList = null;
		if (logger.isDebugEnabled()) {
			logger.debug("selectDeptID() - start 인수 : "); //$NON-NLS-1$
		}

		SqlSession sqlSession = null;
		DeptDAO deptDAO = null;
		try {
			sqlSession = MybatisApp.getSessionjFactory().openSession();
			deptDAO = DeptDAO.getInstance();
			//---------------------------------------------------------------
			// 여기가 바뀐다.
			deptList = deptDAO.selectDeptID(sqlSession);
			//---------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			logger.error("selectDeptID() 에러 : " + e.getMessage()); //$NON-NLS-1$
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("selectDeptID() - end 리턴 : " + deptList); //$NON-NLS-1$
		}		
		return deptList;
	}
	// 직업만
	public List<String> selectJobID(){
		List<String> jobList = null;
		if (logger.isDebugEnabled()) {
			logger.debug("selectJobID() - start 인수 : "); //$NON-NLS-1$
		}
		
		SqlSession sqlSession = null;
		DeptDAO deptDAO = null;
		try {
			sqlSession = MybatisApp.getSessionjFactory().openSession();
			deptDAO = DeptDAO.getInstance();
			//---------------------------------------------------------------
			// 여기가 바뀐다.
			jobList = deptDAO.selectJobID(sqlSession);
			//---------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			logger.error("selectJobID() 에러 : " + e.getMessage()); //$NON-NLS-1$
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("selectJobID() - end 리턴 : " + jobList); //$NON-NLS-1$
		}		
		return jobList;
	}
	// 전체목록
	public List<DeptVO> selectAll(){
		List<DeptVO> list = null;
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll() - start 인수 : "); //$NON-NLS-1$
		}
		
		SqlSession sqlSession = null;
		DeptDAO deptDAO = null;
		try {
			sqlSession = MybatisApp.getSessionjFactory().openSession();
			deptDAO = DeptDAO.getInstance();
			//---------------------------------------------------------------
			// 여기가 바뀐다.
			list = deptDAO.selectAll(sqlSession);
			//---------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			logger.error("selectAll() 에러 : " + e.getMessage()); //$NON-NLS-1$
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll() - end 리턴 : " + list); //$NON-NLS-1$
		}		
		return list;
	}
	// 부서목록
	public List<DeptVO> selectByDeptID(String dept_id){
		List<DeptVO> list = null;
		if (logger.isDebugEnabled()) {
			logger.debug("selectByDeptID(int) - start 인수 : " + dept_id); //$NON-NLS-1$
		}
		
		SqlSession sqlSession = null;
		DeptDAO deptDAO = null;
		try {
			sqlSession = MybatisApp.getSessionjFactory().openSession();
			deptDAO = DeptDAO.getInstance();
			//---------------------------------------------------------------
			// 여기가 바뀐다.
			list = deptDAO.selectByDeptID(sqlSession, dept_id);
			//---------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			logger.error("selectByDeptID(int) 에러 : " + e.getMessage()); //$NON-NLS-1$
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("selectByDeptID(int) - end 리턴 : " + list); //$NON-NLS-1$
		}		
		return list;
	}
	// 전체/부서/직업/부서직업 목록
	public List<DeptVO> selectDept(String dept_id, String job_id){
		List<DeptVO> list = null;
		if (logger.isDebugEnabled()) {
			logger.debug("selectDept(int) - start 인수 : " + dept_id + ", " + job_id); //$NON-NLS-1$
		}
		
		SqlSession sqlSession = null;
		DeptDAO deptDAO = null;
		try {
			sqlSession = MybatisApp.getSessionjFactory().openSession();
			deptDAO = DeptDAO.getInstance();
			//---------------------------------------------------------------
			// 여기가 바뀐다.
			HashMap<String, String> map = new HashMap<>();
			if(dept_id==null || dept_id.trim().length()==0) dept_id=null;
			if(job_id==null || job_id.trim().length()==0) job_id=null;
			map.put("dept_id", dept_id);
			map.put("job_id", job_id);

			list = deptDAO.selectDept(sqlSession, map);
			//---------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			logger.error("selectDept(int) 에러 : " + e.getMessage()); //$NON-NLS-1$
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("selectByDeptID(int) - end 리턴 : " + list); //$NON-NLS-1$
		}		
		return list;
	}

}
