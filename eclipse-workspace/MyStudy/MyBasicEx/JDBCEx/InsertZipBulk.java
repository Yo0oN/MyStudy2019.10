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

public class InsertZipBulk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//bulk insert로 넣어주자.
		BufferedReader br = null;
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt =null;
		
		
		try {
			br = new BufferedReader(new FileReader("C:\\java\\OneDrive\\Java\\eclipse\\eclipse-workspace\\MyStudy\\MyBasicEx\\JDBCEx\\zipcode_seoul_utf8_type2.csv"));
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			String data = null;
			
			int rowCount = 0;
			StringBuffer sql = new StringBuffer();
			sql.append("insert into zipcode values ");
			//내용 전부를 방에 넣어?
			while ((data=br.readLine())!=null) {
				String[] datas = data.split(",");
				
				
				String sqlvalue = String.format("('%s', '%s','%s','%s','%s','%s',%s),", 
						datas[0], datas[1], datas[2],datas[3],datas[4],datas[5],datas[6]);
				
				// 넣을 데이터들을 더한다
				sql.append(sqlvalue).toString();
			}
			// 마지막 쉼표를 어떻게 없앨까?
			// -> length를 이용하여 마지막쉼표가 몇번째에 있는지 알려주고, 그것을 지운다. 
			sql.deleteCharAt(sql.length()-1);
			
			rowCount += stmt.executeUpdate(sql.toString());
			System.out.println("입력된 행수 : " + rowCount);
			
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
