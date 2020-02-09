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

public class SearchZipcodeUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 동을 외부에서 입력받고 DB에서 검색하여 우편번호를 출력해주어라.
		SearchUtil su = new SearchUtil();

		try {
			String strDong = su.inputDong();
			// String result = su.searchDong(strDong);
			// System.out.println(result);
			// ArrayList<String> result = su.searchDong(strDong);
			// for (String results : result) {
			// System.out.println(results);
			// }
			ArrayList<ZipcodeTO> result = su.searchDong(strDong);
			for (ZipcodeTO to : result) {
				System.out.printf("[%s] %3s %5s %4s %5s%n",
						to.getZipcode(), to.getSido(), to.getGugun(),
						to.getDong(), to.getRi());

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
