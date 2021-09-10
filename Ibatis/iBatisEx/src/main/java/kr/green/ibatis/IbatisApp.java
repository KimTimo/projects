package kr.green.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisApp {
	private static SqlMapClient sqlMapClient;
	// 정적 초기화 블록
	static{
		try {
			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	
	public static void main(String[] args) {
		SqlMapClient sqlMapClient = IbatisApp.getSqlMapClient();
		System.out.println("연결 성공 : " + sqlMapClient);
		// 트랜젝션 처리
		try {
			// 1 . 트랜젝션 시작
			sqlMapClient.startTransaction();
			
			String today = (String) sqlMapClient.queryForObject("test.now");
			System.out.println("DB 서버 시간 : " + today);
			
			HashMap<String, Integer> map = new HashMap<>();
			map.put("num1", 12);
			map.put("num2", 6);
			map.put("num3", 10);
			
			int result = (int) sqlMapClient.queryForObject("test.calc", map);
			System.out.println("계산 결과 : " + result);
			
			// 2. 트랜젝션 적용
			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			// 전에는 여기에서 rollback을 해주었다. 
			e.printStackTrace();
		} finally {
			// 3. 트랜젝션 종료
			try {
				sqlMapClient.endTransaction(); // commitTransaction()이 실행되지 않았으면 자동으로 rollback을 수행한다.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
