package SimpleBoard01ActionSubController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimpleBoard01Model.SimpleBoard01DAO;
import SimpleBoard01Model.SimpleBoard01DAO;
import SimpleBoard01Model.SimpleBoard01TO;

public class SimpleBoard01list1 implements SimpleBoard01Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("List1 SubController 호출");

		SimpleBoard01DAO dao = new SimpleBoard01DAO();

		ArrayList<SimpleBoard01TO> boardLists = dao.boardList();

		request.setAttribute("boardLists", boardLists);
	}

}
