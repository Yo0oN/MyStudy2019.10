package JDBCEx;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertZip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		String url = "jdbc:mysql://192.168.0.4:3306/employees";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt =null;
		
		
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\kitcoop\\OneDrive\\Java\\eclipse-workspace\\JDBCEx01\\zipcode_seoul_utf8_type2.csv"));
			
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			String data = null;
			
			int rowCount = 0;
			
			while ((data=br.readLine())!=null) {
				String[] datas = data.split(",");
				String sql = String.format("insert into zipcode values ('%s', '%s','%s','%s','%s','%s',%s)", 
						datas[0], datas[1], datas[2],datas[3],datas[4],datas[5],datas[6]);
				rowCount += stmt.executeUpdate(sql);
			}
			
			System.out.println("입력될 행수 : " + rowCount);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) {try { stmt.close(); } catch (SQLException e) {}}
			if (conn != null) {try { conn.close(); } catch (SQLException e) {}}
			if (br != null) {try { br.close(); } catch (IOException e) {}}
		}
		
	}

}
