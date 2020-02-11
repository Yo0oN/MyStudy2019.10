package MyBatisModelPagingModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisPagingBoardDAO {
	private SqlSession sqlSession;

	public MyBatisPagingBoardDAO() {
		String resource = "myBatisConfig.xml";

		InputStream is = null;

		try {
			is = Resources.getResourceAsStream(resource);

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

			this.sqlSession = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			System.out.println("error : " + e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
	}

	// board_list1.jsp
	public MyBatisPagingBoardListTO boardList(MyBatisPagingBoardListTO listTO) {
		// cpage - paging
		// 현재페이지
		int cpage = listTO.getCpage();
		// 한 페이지에 몇개의 글이 들어가는가?
		int recordPerPage = listTO.getRecordPerPage();
		// 한 블럭에 몇개가 들어가는가?
		int blockPerPage = listTO.getBlockPerPage();

		ArrayList<MyBatisPagingBoardTO> boardLists = (ArrayList) sqlSession.selectList("list");

		// 총 글 수
		listTO.setTotalRecord(boardLists.size());

		// 총 페이지 수
		listTO.setTotalPage(((listTO.getTotalRecord() - 1) / recordPerPage) + 1);

		// 페이지에서 보이는 글의 시작 번호
		int fromIndex = (cpage - 1) * recordPerPage;
		// 페이지에서 보이는 글의 마지막번호
		int toIndex = fromIndex + recordPerPage;
		// 마지막페이지의 글이 10개가 안될경우 toIndex를 조정해준다. 
		if (toIndex >= listTO.getTotalRecord()) {
			toIndex = listTO.getTotalRecord();
		}
		
		// 실제로 보여질 글들만 담을 boardListsShow
		// subList(시작번호, 끝번호) List안에서 시작번호부터 끝번호까지만 List로 반환한다.
		ArrayList<MyBatisPagingBoardTO> boardListsShow = new ArrayList<>(boardLists.subList(fromIndex, toIndex));
		
		/*
		 * // 보여질글 개수만큼만 담아둔다. 위의 56~67행의 내용과 같은뜻이다.
		 * ArrayList<MyBatisPagingBoardTO> boardListsShow = new ArrayList();
		 * for (int i = fromIndex; i < (fromIndex + recordPerPage) && !boardLists.isEmpty(); i++) {
		 * boardListsShow.add(boardLists.get(i));
		 * }
		 */
		
		// 담은것을 listTO에 넘긴다.
		listTO.setBoardLists(boardListsShow);

		// 블럭 시작번호
		listTO.setStartBlock(((cpage - 1) / blockPerPage) * blockPerPage + 1);
		// 블럭 끝번호
		listTO.setEndBlock(((cpage - 1) / blockPerPage) * blockPerPage + blockPerPage);

		if (listTO.getEndBlock() >= listTO.getTotalPage()) {
			listTO.setEndBlock(listTO.getTotalPage());
		}

		if (sqlSession != null) {
			sqlSession.close();
		}

		return listTO;
	}

	// board_write1.jsp
	public void boardWrite() {
		// 사용하지 않음

	}

	// board_write1_ok.jsp
	public int boardWriteOk(MyBatisPagingBoardTO to) {
		int flag = 1;
		int result = sqlSession.insert("writeOk", to);

		if (result == 1) {
			flag = 0;
		}

		if (sqlSession != null) {
			sqlSession.close();
		}

		return flag;
	}

	public MyBatisPagingBoardTO boardView(MyBatisPagingBoardTO to) {
		// 글을 보게되면 조회수를 먼저 올린 후
		sqlSession.update("view_hit", to);
		// 글을 보여준다.
		to = sqlSession.selectOne("view", to);

		if (sqlSession != null)
			sqlSession.close();

		return to;
	}

	public MyBatisPagingBoardTO boardModify(MyBatisPagingBoardTO to) {

		to = sqlSession.selectOne("modify", to);

		if (sqlSession != null)
			sqlSession.close();

		return to;
	}

	public int boardModifyOk(MyBatisPagingBoardTO to) {
		int flag = 2;

		int result = sqlSession.update("modifyOk", to);

		if (result == 1) {
			flag = 0;
		} else if (result == 0) {
			flag = 1;
		}
		return flag;
	}

	public MyBatisPagingBoardTO boardDelete(MyBatisPagingBoardTO to) {

		to = sqlSession.selectOne("delete", to);

		if (sqlSession != null)
			sqlSession.close();

		return to;
	}

	public int boardDeleteOk(MyBatisPagingBoardTO to) {
		int flag = 2;
		int result = sqlSession.delete("deleteOk", to);

		if (result == 0) {
			flag = 1;
		} else if (result == 1) {
			flag = 0;
		}

		if (sqlSession != null)
			sqlSession.close();

		return flag;
	}
}
