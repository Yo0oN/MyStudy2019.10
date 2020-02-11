package JDBCEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchUtil {

	public String inputDong() throws IOException { // 동이름입력 메서드 BufferedReader br
		BufferedReader br = null;
		String strDong = null;

		br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("동이름 입력 : ");

		strDong = br.readLine();
//		System.out.println(strDong);

		if (br != null) {
			br.close();
		}
		return strDong;
	}

//	  public void searchDong(String strDong) throws ClassNotFoundException, SQLException {
//			// 검색용 메서드
//			String url = "jdbc:mysql://127.0.0.1:3306/employees";
//			String user = "root";
//			String password = "123456";
//
//			Connection conn = null;
//			Statement stmt = null;
//			ResultSet rs = null;
//
//			Class.forName("org.mariadb.jdbc.Driver");
//
//			conn = DriverManager.getConnection(url, user, password);
//
//			stmt = conn.createStatement();
//
//			String sql = String.format("select * from zipcode where dong like '%%%s%%'", strDong);
//
//			rs = stmt.executeQuery(sql);
//			
//			while (rs.next()) {
//				System.out.printf("[%s] %3s %5s %4s %5s%n", rs.getString("zipcode"), rs.getString("sido"),
//						rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"));
//			}
//
//			if (rs != null)
//				rs.close();
//			if (stmt != null)
//				stmt.close();
//			if (conn != null)
//				conn.close();
//			
//	  
//	public String searchDong(String strDong) throws ClassNotFoundException, SQLException {
//		// 검색용 메서드
//		String url = "jdbc:mysql://127.0.0.1:3306/employees";
//		String user = "root";
//		String password = "123456";
//
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		Class.forName("org.mariadb.jdbc.Driver");
//
//		conn = DriverManager.getConnection(url, user, password);
//
//		stmt = conn.createStatement();
//
//		String sql = String.format("select * from zipcode where dong like '%%%s%%'", strDong);
//
//		rs = stmt.executeQuery(sql);
//		
//		String result = null;
//		while (rs.next()) {
//			result += String.format("[%s] %3s %5s %4s %5s%n", rs.getString("zipcode"), rs.getString("sido"),
//					rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"));
//		}
//
//		if (rs != null)
//			rs.close();
//		if (stmt != null)
//			stmt.close();
//		if (conn != null)
//			conn.close();
//		
//		return result;
//
//	public ArrayList<String> searchDong(String strDong) throws ClassNotFoundException, SQLException {
//		// 검색용 메서드
//		String url = "jdbc:mysql://127.0.0.1:3306/employees";
//		String user = "root";
//		String password = "123456";
//
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		Class.forName("org.mariadb.jdbc.Driver");
//
//		conn = DriverManager.getConnection(url, user, password);
//
//		stmt = conn.createStatement();
//
//		String sql = String.format("select * from zipcode where dong like '%%%s%%'", strDong);
//
//		rs = stmt.executeQuery(sql);
//
//		ArrayList<String> result = new ArrayList<String>();
//
//		while (rs.next()) {
//			result.add(String.format("[%s] %3s %5s %4s %5s", rs.getString("zipcode"), rs.getString("sido"),
//					rs.getString("gugun"), rs.getString("dong"), rs.getString("ri")));
//		}
//
//		if (rs != null)
//			rs.close();
//		if (stmt != null)
//			stmt.close();
//		if (conn != null)
//			conn.close();
//
//		return result;
//	}

	public ArrayList<ZipcodeTO> searchDong(String strDong) throws ClassNotFoundException, SQLException {
		// 검색용 메서드
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Class.forName("org.mariadb.jdbc.Driver");

		conn = DriverManager.getConnection(url, user, password);

		stmt = conn.createStatement();

		String sql = String.format("select * from zipcode where dong like '%%%s%%'", strDong);

		rs = stmt.executeQuery(sql);

		ArrayList<ZipcodeTO> result = new ArrayList<ZipcodeTO>();

		while (rs.next()) {
			ZipcodeTO to = new ZipcodeTO();
			to.setZipcode(rs.getString("zipcode"));
			to.setSido(rs.getString("sido"));
			to.setGugun(rs.getString("gugun"));
			to.setDong(rs.getString("dong"));
			to.setRi(rs.getString("ri"));
			to.setBunji(rs.getString("bunji"));
			to.setSeq(rs.getString("seq"));

			result.add(to);

		}

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();

		return result;

	}

}
