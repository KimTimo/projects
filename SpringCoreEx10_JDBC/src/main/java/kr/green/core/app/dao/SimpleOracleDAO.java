package kr.green.core.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("oracleDAO")
public class SimpleOracleDAO implements SimpleDAO {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public String getNow() {
		String date = "";
		String sql = "select sysdate from dual";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = dataSource.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			date = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { rs.close(); } catch (SQLException e) { ; }
			try { stmt.close(); } catch (SQLException e) { ; }
		}
		
		return date;
	}

	@Override
	public int getCalc(int num1, int num2) {
		int result = 0;
		String sql = "select " + num1 + " * " +  num2 + " from dual";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = dataSource.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { rs.close(); } catch (SQLException e) { ; }
			try { stmt.close(); } catch (SQLException e) { ; }
		}
		return result;
	}

}
