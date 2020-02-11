package SwingZipCodeTableEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBCEx.ZipcodeTO;

public class ZipCodeDAO {
	// DB에서 데이터 받아오는곳
	private Connection conn;
	
	public ZipCodeDAO() {
		// TODO Auto-generated constructor stub
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
	
	public ArrayList<ZipcodeTO> selectZipCode(){
		// DB에서 내용을 받아온 후 ZipcodeTO에 저장하여 배열로 뽑아주는 메소드 생성
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// DB에서 온 데이터를 저장할 ArrayList
		
		ArrayList<ZipcodeTO> datas = new ArrayList<ZipcodeTO>();

		try {
			// DB에 명령실행
			String sql = "select * from zipcode";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 읽어올 데이터가 계속 있을 때까지 데이터를 읽어 온 후 datas에 저장
			while (rs.next()) {
				ZipcodeTO to = new ZipcodeTO();
				// to(ZipcodeTO)의 각각의 변수에 값 저장함
				to.setZipcode(rs.getString("zipcode"));
				to.setSido(rs.getString("sido"));
				to.setGugun(rs.getString("gugun"));
				to.setDong(rs.getString("dong"));
				to.setRi(rs.getString("ri"));
				to.setBunji(rs.getString("bunji"));
				to.setSeq(rs.getString("seq"));
				// 저장한것을 datas에 한행씩 넣어줌
				datas.add(to);
			}
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if (rs != null) {try {rs.close();} catch (SQLException e) {}}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if (conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
		
		return datas;
	}

}
