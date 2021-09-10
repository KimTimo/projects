package kr.green.mvc07.dao;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.green.mvc07.vo.TestVO;

@Repository("testDAO")
public class TestDAOImpl implements TestDAO  {

	@Autowired
	private SqlMapClient sqlMapClient;

	@Override
	public String today() throws SQLException {
		return (String) sqlMapClient.queryForObject("test.today");
	}

	@Override
	public int sum(int num1, int num2) throws SQLException {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("num1", num1);
		map.put("num2", num2);
		return (int) sqlMapClient.queryForObject("test.sum", map);
	}

	@Override
	public int mul(int num1, int num2) throws SQLException {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("num1", num1);
		map.put("num2", num2);
		return (int) sqlMapClient.queryForObject("test.mul", map);
	}

	@Override
	public TestVO getTestVO(TestVO testVO) throws SQLException {
		return (TestVO) sqlMapClient.queryForObject("test.vo", testVO);
	}
}
