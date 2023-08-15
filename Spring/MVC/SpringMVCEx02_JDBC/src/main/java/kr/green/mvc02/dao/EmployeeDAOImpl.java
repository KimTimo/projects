package kr.green.mvc02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.green.mvc02.vo.EmployeeVO;

@Repository("employeeDAO") // Bean 등록
public class EmployeeDAOImpl implements EmployeeDAO {

	// DB 연결 객체 자동주입
	@Autowired
	private DataSource dataSource;

	@Override
	public void save(EmployeeVO employee) {
		String sql = "insert into employee values (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getRole());
			if (pstmt.executeUpdate() > 0)
				System.out.println(employee + "저장 성공!!!!!");
			else
				System.out.println(employee + "저장 실패!!!");
		} catch (Exception e) {
			System.out.println("에러발생 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public EmployeeVO getById(int id) {
		EmployeeVO employeeVO = null;
		String sql = "select * from employee where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				employeeVO = new EmployeeVO();
				employeeVO.setId(rs.getInt("id"));
				employeeVO.setName(rs.getString("name"));
				employeeVO.setRole(rs.getString("role"));
				System.out.println(employeeVO + "읽음");
			} else {
				System.out.println(id + "번 데이터가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println("에러발생 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeVO;
	}

	@Override // 수정
	public void update(EmployeeVO employee) {
		String sql = "update employee set name=?, role=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getRole());
			pstmt.setInt(3, employee.getId());
			if (pstmt.executeUpdate() > 0)
				System.out.println(employee + "수정 성공!!!!!");
			else
				System.out.println(employee + "수정 실패!!!");
		} catch (Exception e) {
			System.out.println("에러발생 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override // 삭제
	public void deleteById(int id) {
		String sql = "delete from employee where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if(pstmt.executeUpdate()>0)
				System.out.println(id + "삭제 성공!!!!!");
			else
				System.out.println(id + "삭제 실패!!!");
		}catch (Exception e) {
			System.out.println("에러발생 : " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override // 모두 읽기
	public List<EmployeeVO> getAll() {
		List<EmployeeVO> list = null;
		String sql = "select * from employee";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<>();
				do {
					EmployeeVO employeeVO = new EmployeeVO();
					employeeVO = new EmployeeVO();
					employeeVO.setId(rs.getInt("id"));
					employeeVO.setName(rs.getString("name"));
					employeeVO.setRole(rs.getString("role"));
					System.out.println(employeeVO + "읽음");
					list.add(employeeVO);
				}while(rs.next());
			} else {
				System.out.println("데이터가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println("에러발생 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
