import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import config.SqlMapperInterface;
import model1.DeptTO;

public class MyBatisEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "myBatisConfig.xml";
		SqlSession sqlSession = null;

		InputStream is = null;

		try {
			is = Resources.getResourceAsStream(resource);

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

			sqlSession = sqlSessionFactory.openSession(true);

			// annotation을 사용하면 아래의 문장이 더 필요하다.
			sqlSession.getConfiguration().addMapper(SqlMapperInterface.class);
			SqlMapperInterface mapper = (SqlMapperInterface) sqlSession.getMapper(SqlMapperInterface.class);

			// select
			ArrayList<DeptTO> lists = mapper.selectList();
			for (DeptTO to : lists) {
				System.out.println(to.getDeptno());
			}
			// parameter를 전달해주는 select
			DeptTO deptTO1 = mapper.selectByDeptno("30");
			System.out.println(deptTO1.getDeptno() + " / " + deptTO1.getDname() + " / " + deptTO1.getLoc());

			// insert
			DeptTO setTO = new DeptTO();
			setTO.setDeptno("80");
			setTO.setDname("연구");
			setTO.setLoc("대구");

			int insertResult = mapper.insertDept(setTO);
			if (insertResult == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

		} catch (IOException e) {
			System.out.println("error" + e.getMessage());
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
