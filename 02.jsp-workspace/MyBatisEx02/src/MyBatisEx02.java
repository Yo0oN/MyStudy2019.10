import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "myBatisConfig.xml";

		InputStream is = null;
		SqlSession sqlSession = null;

		try {
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

			sqlSession = sqlSessionFactory.openSession(true);

			DeptTO to = new DeptTO();

			to.setDeptno("80");
			to.setDname("개발");
			to.setLoc("인천");

			// 결과는 1이 찍혀서 입력된것처럼 보이나
			// 내부적으로 buffer를 가지고있어, 수락을 하기 전까지는 입력이 중단됨.
			int result = sqlSession.insert("insert1", to);
			// 그렇기때문에 commit을 이용하여 수락을 해주어야 한다.
			// sqlSession.commit();
			
			if (result == 0) {
				System.out.println("실패");
			} else {
				System.out.println("성공");
			}

			/*
			 * ArrayList<EmpTO> lists2 = (ArrayList)
			 * sqlSession.selectList("mybatis.selectList2");
			 * 
			 * for (int i = 0; i < lists2.size(); i++) { EmpTO to = lists2.get(i);
			 * 
			 * System.out.print("empno : " + to.getEmpno()); System.out.print("	ename : " +
			 * to.getEname()); System.out.print("	sal : " + to.getSal());
			 * System.out.print("	deptno : " + to.getDeptno());
			 * System.out.println("	hiredate : " + to.getHiredate()); }
			 */

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
		}
	}

}
