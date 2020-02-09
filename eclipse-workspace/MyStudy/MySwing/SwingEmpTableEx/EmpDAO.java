package SwingEmpTableEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
	private Connection conn;

	public EmpDAO() {
		// TODO Auto-generated constructor stub
		// 데이터 베이스 접속 설정
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

	public ArrayList<EmpTO> selectEmp() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<EmpTO> datas = new ArrayList<EmpTO>();

		try {
			// emp테이블의 모든 데이터를 가져오도록 명령
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 가져온 데이터를 한 행씩 읽는다.
			while (rs.next()) {
				// EmpTO 클래스의 변수들에 데이터를 저장한다.
				EmpTO to = new EmpTO();
				to.setEmpno(rs.getString("empno"));
				to.setEname(rs.getString("ename"));
				to.setJob(rs.getString("job"));
				to.setMgr(rs.getString("mgr"));
				to.setHiredate(rs.getString("hiredate"));
				to.setSal(rs.getString("sal"));
				to.setComm(rs.getString("comm"));
				to.setDeptno(rs.getString("deptno"));
				// EmpTO에 저장되어있는 데이터를 datas에 넣는다.
				datas.add(to);
			}
			// 데이터를 반환한다.
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if (rs != null) { try {rs.close();} catch (SQLException e) {}}
			if (pstmt != null) { try {pstmt.close();} catch (SQLException e) {}}
			if (conn != null) { try {conn.close();} catch (SQLException e) {}}
		}
		return datas;
	}
}
