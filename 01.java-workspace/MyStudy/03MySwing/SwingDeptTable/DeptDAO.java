package SwingDeptTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO {
	// DB에서 데이터 빼오는곳
	private ArrayList<DeptTO> datas = null;
	
	private Connection conn = null;
	
	public DeptDAO() {
		// TODO Auto-generated constructor stub
		// DB 접근
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("[에러 1] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[에러 2] : " + e.getMessage());
		}
	}
	
	public ArrayList<DeptTO> getDept() {
		// DB에서 데이터 빼와서 저장하기
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		datas = new ArrayList<DeptTO>();
		
		try {
			// DB에 데이터 달라고 명령
			String sql = "select * from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 데이터 없을때까지 계속 데이터 읽기
			while(rs.next()) {
				DeptTO to = new DeptTO();
				// 읽어오는 것들 DeptTO에 저장
				to.setDeptno(rs.getString("deptno"));
				to.setDname(rs.getString("dname"));
				to.setLoc(rs.getString("loc"));
				
				// DeptTO에 저장된 데이터들을 datas에 차례로 저장
				datas.add(to);
			}
		} catch (SQLException e) {
			System.out.println("[에러3] : " + e.getMessage());
		} finally {
			if (rs != null) {try {rs.close();} catch (SQLException e) {}}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if (conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
		
		return datas;
	}

}
