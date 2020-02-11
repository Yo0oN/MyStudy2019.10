import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int resulti;
	private String results;
	private boolean next;

	public MainDAO() {
		// DB 접속
		String url = "jdbc:mysql://192.168.0.23:3306/account_book";
		String user = "root";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String ID(String user) {
		return null;
	}

	// 남은돈 알려주기
	public String LeftMoney(int m_num) {
		try {
			String sql = "select m_money from Member_info where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				results = rs.getString("m_money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	// 사용한 돈 알려주기
	public String UseMoney(int m_num) {
		try {
			String sql = "select m_usemoney from Member_info where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				results = rs.getString("m_usemoney");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	// 총 입금액 알려주기
	public String GetMoney(int m_num) {
		try {
			String sql = "select m_getmoney from Member_info where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				results = rs.getString("m_getmoney");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	// 지출만
	public ArrayList<AccountBookTableTO> SearchUseMoney(int m_num, String date) {
		ArrayList<AccountBookTableTO> datas = new ArrayList<AccountBookTableTO>();

		try {
			String sql = "select u_date, u_section1, u_section2, u_money, u_cash_card from use_money "
					+ "where m_num = ? and u_date like ? order by u_date desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AccountBookTableTO to = new AccountBookTableTO();
				to.setU_date(rs.getString("u_date"));
				to.setU_section1(rs.getString("u_section1"));
				to.setU_section2(rs.getString("u_section2"));
				to.setU_money(rs.getString("u_money"));
				to.setU_cash_card(rs.getString("u_cash_card"));
				datas.add(to);
			}
		} catch (SQLException e) {
			System.out.println("error use : " + e.getMessage());
		}
		return datas;
	}

	// 입금만
	public ArrayList<AccountBookTableTO> SearchGetMoney(int m_num, String date) {
		ArrayList<AccountBookTableTO> datas = new ArrayList<AccountBookTableTO>();

		try {
			String sql = "select g_date, g_section1, g_section2, g_money from get_money "
					+ "where m_num = ? and g_date like ? order by g_date desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AccountBookTableTO to = new AccountBookTableTO();
				to.setG_date(rs.getString("g_date"));
				to.setG_section1(rs.getString("g_section1"));
				to.setG_section2(rs.getString("g_section2"));
				to.setG_money(rs.getString("g_money"));
				datas.add(to);
			}
		} catch (SQLException e) {
			System.out.println("error get : " + e.getMessage());
		}
		return datas;
	}

	// 지출, 수입 모두
	public ArrayList<AccountBookTableTO> SearchAllMoney(int m_num, String date) {
		ArrayList<AccountBookTableTO> datas = new ArrayList<AccountBookTableTO>();

		try {
			String sql = "select date, section1, section2, money, cc from (\r\n"
					+ "(select g_date date, g_section1 section1, g_section2 section2, g_money money, g_cash_card cc "
					+ "from get_money g where g.m_num = ?)\r\n"
					+ "union all\r\n"
					+ "(select u_date date, u_section1 section1, u_section2 section2, u_money*-1 money, u_cash_card cc "
					+ "from use_money u where u.m_num = ?)\r\n"
					+ ") unionmoney where date like ? order by date desc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			pstmt.setString(2, m_num + "");
			pstmt.setString(3, date);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AccountBookTableTO to = new AccountBookTableTO();
				to.setDate(rs.getString("date"));
				to.setSection1(rs.getString("section1"));
				to.setSection2(rs.getString("section2"));
				to.setMoney(rs.getString("money"));
				to.setCash_card(rs.getString("cc"));
				datas.add(to);
			}
		} catch (SQLException e) {
			System.out.println("error all : " + e.getMessage());
		}
		return datas;
	}

	//
	public ArrayList<StatsTableTO> StatsGetMoney(int m_num, String date) {
		ArrayList<StatsTableTO> datas = new ArrayList<StatsTableTO>();

		try {
			String sql = "select g_section1, sum(g_money) g_money from get_money "
					+ "where m_num = ? and g_date like ? " + "group by g_section1 order by 2 desc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StatsTableTO to = new StatsTableTO();
				to.setG_section1(rs.getString("g_section1"));
				to.setG_money(rs.getString("g_money"));
				datas.add(to);
			}

		} catch (SQLException e) {
		}
		return datas;
	}

	public ArrayList<StatsTableTO> StatsUseMoney(int m_num, String date) {
		ArrayList<StatsTableTO> datas = new ArrayList<StatsTableTO>();

		try {
			String sql = "select u_section1, sum(u_money) u_money from use_money "
					+ "where m_num = ? and u_date like ? " + "group by u_section1 order by 2 desc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StatsTableTO to = new StatsTableTO();
				to.setU_section1(rs.getString("u_section1"));
				to.setU_money(rs.getString("u_money"));
				datas.add(to);
			}

		} catch (SQLException e) {
		}
		return datas;
	}
	
	public String getMyData(int m_num) {
		try {
			String sql = "select m_joinDate from Member_info where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				results = rs.getString("m_joinDate");
			}
		} catch (SQLException e) {
		}
		return results;
	}
}
