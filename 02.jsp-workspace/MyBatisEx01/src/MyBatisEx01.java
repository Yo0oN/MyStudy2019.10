
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisEx01 {

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

			// select1이라는 id를 가진것의 결과를 가져온다.
			// 앞에 mybatis를 붙여 mybatis이름안의 select1을 가져온다는 정확한 경로를 입력해도 된다.
			// DeptTO to = (DeptTO) sqlSession.selectOne("mybatis.select1");
			// mybatis.select2에 있는 select 문을 실행한 결과를 가져오는데, parameter를 20으로 설정해준다. 
			// DeptTO to = (DeptTO) sqlSession.selectOne("mybatis.select2", "20");
			
			// select3의 결과를 가져오는데, 파라미터를 2개 이상 지정해줄 경우
			// 한 클래스를 이용하여, 그 객체에 설정해줄 값을 넣고, 객체를 넘긴다. 
			DeptTO pTO = new DeptTO();
			pTO.setDeptno("10");
			pTO.setDname("ACCOUNTING");
			// 파라미터값이 들어있는 객체를 넘기면, select문이 실행되어 결과가 나온다.
			DeptTO to = (DeptTO) sqlSession.selectOne("mybatis.select3", pTO);
			
			if (to != null) {
				System.out.print("deptno : " + to.getDeptno());
				System.out.print(" / dname : " + to.getDname());
				System.out.println(" / loc : " + to.getLoc());
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
