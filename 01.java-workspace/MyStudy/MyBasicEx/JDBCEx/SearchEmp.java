package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 부서정보를 입력받아 사원에 대한 정보를 출력하는 자바프로그램 작성
		// java SearchEmp클래스에서
		// 부서번호 : 입력
		// 사원번호 사원명 급여 연봉 입사일 부서명 부서위치
		// 형식으로 출력되게 하여라.
		// 단 부서번호가 숫자로 입력되지 않으면 재입력창이 뜨게 하여라.
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";
		;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.createStatement();

			while (true) {
				try {
					Scanner sc = new Scanner(System.in);

					System.out.print("부서번호 : ");

					int deptnoi = sc.nextInt();

					String sql = String.format(
							"select empno, ename, floor(sal), floor(sal*12+ifnull(comm,0)), date_format(hiredate, '%%Y년 %%m월 %%d일'), d.dname, d.loc from emp e inner join dept d where e.deptno = d.deptno and e.deptno='%d'",
							deptnoi);

					// 쿼리 입력
					rs = stmt.executeQuery(sql);

					// 결과 출력
					while (rs.next()) {
						System.out.printf("%-5s%-6s%-6s%-7s%-15s%-10s%-10s%n", rs.getString(1), rs.getString(2),
								rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
					}

					if (rs.next() != true) {
						break;
					}

				} catch (InputMismatchException e) {
					System.out.println("10부터 40까지의 숫자로 입력해주세요!");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("1" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("2" + e.getMessage());
		}
	}

}
