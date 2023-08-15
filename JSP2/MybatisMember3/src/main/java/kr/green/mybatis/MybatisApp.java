package kr.green.mybatis;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisApp {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		// 마이바티스 연결을 한다.
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	// 여기서 직접 main에서 연결 테스트
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
		System.out.println("연결 성공 : " + sqlSession);
		sqlSession.close();
	}
	
	// JUnit을 이용한 테스트
	@Test
	public void test() {
		SqlSession sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
		assertNotNull(sqlSession);
		sqlSession.close();
	}
	
}
