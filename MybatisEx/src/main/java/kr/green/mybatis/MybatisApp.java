package kr.green.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

public class MybatisApp {
	private static SqlSessionFactory mariaSessionFactory;
	private static SqlSessionFactory oracleSessionFactory;
	
	static {
		String resource = "mybatis-mariadb-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			mariaSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		resource = "mybatis-oracle-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			oracleSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getMariaSessionFactory() {
		return mariaSessionFactory;
	}
	
	public static SqlSessionFactory getOracleSessionFactory() {
		return oracleSessionFactory;
	}
	
	
}
