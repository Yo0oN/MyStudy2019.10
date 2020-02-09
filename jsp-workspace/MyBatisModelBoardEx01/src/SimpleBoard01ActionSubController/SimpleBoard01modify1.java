package SimpleBoard01ActionSubController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimpleBoard01Model.SimpleBoard01DAO;
import SimpleBoard01Model.SimpleBoard01TO;

public class SimpleBoard01modify1 implements SimpleBoard01Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Modify1 SubController 호출");

		SimpleBoard01TO to = new SimpleBoard01TO();

		to.setSeq(request.getParameter("seq"));
		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		to = dao.boardModify(to);

		request.setAttribute("to", to);

	}

}
