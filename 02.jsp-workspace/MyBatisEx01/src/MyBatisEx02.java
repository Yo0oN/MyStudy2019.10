
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisEx02 {

	public static void main(String[] args) {
		// myBatisConfig.xml을 읽어 DB접속
		String resource = "myBatisConfig.xml";
		InputStream is = null;
		SqlSession sqlSession = null;

		try {
			// 설정파일을 읽을 때 mapper에서 설정된 id에 해당하는 sql문도 함께 읽는다.
			// org.apache.ibatis.io.Resources
			is = Resources.getResourceAsStream(resource);
			// org.apache.ibatis.session.SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			System.out.println("설정이 호출됨");

			// DB 연결
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("데이터베이스 연결");

			// select4라는 id를 가진것의 결과를 HashMap에 담아 가져온다.
			HashMap<String, Object> map = sqlSession.selectOne("mybatis.select4", "10");

			if (map != null) {
				// 컬럼 수가 들어있다.
				System.out.println(map.size());
				// 값을 출력한다
				for (String key : map.keySet()) {
					System.out.println(key + " : " + map.get(key));
				}
			} else {
				System.out.println("데이터가 없습니다.");
			}
		} catch (IOException e) {
			System.out.println("error : " + e.getMessage());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
		}
	}
}
