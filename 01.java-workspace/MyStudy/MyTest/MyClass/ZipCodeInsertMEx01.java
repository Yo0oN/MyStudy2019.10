package MyClass;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipCodeInsertMEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// zipcode의 내용을 테이블에 넣어보자.
		// zipcode내용을 불러온다 => 한줄씩 끊자. => 한줄을 insert에 넣어주기
		BufferedReader br = null;
		FileReader fr = null;
		
		String url = "jdbc:mysql://192.168.0.4:3306/employees";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			fr = new FileReader(".\\zipcode_seoul_utf8_type2.csv");
			br = new BufferedReader(fr);
			// DBMS 접속함
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			String data = null;
						
			// 내용을 한줄씩 불러왔음
			while ((data = br.readLine()) != null) {
					// System.out.print((char)fr.read());
					// 한줄을 배열에 넣었음
					String[] zip = data.split(",");
					
					// 배열에 들어있는것들을 DBMS로 넘기기
					String sql = String.format("insert into zipcode values ('%s', '%s', '%s', '%s', '%s', '%s', %s)",
							zip[0], zip[1], zip[2], zip[3], zip[4], zip[5], zip[6]);
					int result = stmt.executeUpdate(sql);
					for (int i = 0; i<zip.length; i++) {
						zip[i] = null;
					}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외] : " + e.getMessage());
		} finally {
			if (stmt != null) {try { stmt.close(); } catch (SQLException e) {}}
			if (conn != null) {try { conn.close(); } catch (SQLException e) {}}
			if (rs != null) {try { rs.close(); } catch (SQLException e) {}}
		}
		System.out.println("끝");	
	}
}
