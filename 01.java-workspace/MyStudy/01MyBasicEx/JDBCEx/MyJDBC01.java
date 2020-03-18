package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC01 {
	public static void main(String[] args) {

		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "select * from dept";

			rs = stmt.executeQuery(sql);
			// 커서를 제일 마지막으로 옮긴다.
			rs.last();
			// 커서가 제일 마지막 행에 있는지 여부를 알려준다.
			System.out.println(rs.isLast());
			// 현재 커서가 가리키는 행이 몇번째 행인지 알려준다.
			// 커서가 제일 마지막줄에 있으면 그 데이터의 개수가 몇개인지 알려주는것과 같다.
			System.out.println(rs.getRow());
			// 커서를 첫행으로 옮긴다.
			rs.first();
			// 커서가 첫번째 행에 있는지 여부를 알려준다.
			// 여기서 첫번째 행은 데이터를 읽기전에 첫줄 위가 아닌 첫줄을 말한다.
			// 그렇기때문에 여기서 while을 이용하여 읽기 시작하면 2행부터출력,
			// while없이 그냥 rs.getString으로 읽으면 1행이 나온다.
			System.out.println(rs.isFirst());
			// 커서를 이전 행으로 옮긴다.
			rs.previous();
			while (rs.next()) {
				System.out.print(rs.getString("deptno") + " ");
			}
			System.out.println();
			// 커서를 첫행 이전으로 옮긴다.(데이터를 읽기 전 커서의 위치)
			rs.beforeFirst();
			while (rs.next()) {
				System.out.print(rs.getString("deptno") + " ");
			}
			System.out.println();
			rs.first();
			// 커서를 n줄 이동시킨다. 양수이면 아래로, 음수이면 위로
			rs.relative(3);
			System.out.println(rs.getString("deptno"));
			rs.relative(-2);
			System.out.println(rs.getString("deptno"));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}