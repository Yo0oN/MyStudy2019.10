package JFrameTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableDAO {
	private Connection conn;
	private String tableName;
	
	public TableDAO(String tableName) {
		// TODO Auto-generated constructor stub
		
		this.tableName = tableName;
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		}
	}
	
	public ArrayList<ArrayList<String>> selectTable() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		
		try {
			String sql = "select * from " + tableName;
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while( rs.next() ) {
				ArrayList<String> data = new ArrayList<String>();
				
				for(int col = 1 ; col <= rsmd.getColumnCount() ; col++) {
					data.add(rs.getString(col));	
				}
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return datas;
	}
}








