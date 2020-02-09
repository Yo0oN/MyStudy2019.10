package SwingSalgrade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalgradeDAO {
	// DB에서 데이터 받아오는곳
	private ArrayList<SalgradeTO> datas = null;
	private SalgradeTO to = null;
	private Connection conn;
	
	public SalgradeDAO() {
		// DB 연결
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		}
	}
	
	public ArrayList<SalgradeTO> getSalgrade(){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		datas = new ArrayList<SalgradeTO>();
		SalgradeTO to = new SalgradeTO();
		try {
			
			String sql = "select * from salgrade";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				// TO 쪽에 데이터 넣어줬음
				to.setGrade(rs.getString("grade"));
				to.setLosal(rs.getString("losal"));
				to.setHisal(rs.getString("hisal"));
				// ArrayList에 TO의 내용 넣어줌
				datas.add(to);
			}
		} catch (SQLException e) {
			
		}
		// datas 반환
		return datas;
	}
}
