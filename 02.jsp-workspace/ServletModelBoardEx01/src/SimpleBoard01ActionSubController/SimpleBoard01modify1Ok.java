package SimpleBoard01ActionSubController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimpleBoard01Model.SimpleBoard01DAO;
import SimpleBoard01Model.SimpleBoard01TO;

public class SimpleBoard01modify1Ok implements SimpleBoard01Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Modify1Ok SubController 호출");

		SimpleBoard01TO to = new SimpleBoard01TO();

		to.setSeq(request.getParameter("seq"));
		to.setSubject(request.getParameter("subject"));
		String mail = "";
		if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
			to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
		} else {
			to.setMail("");
		}
		to.setPassword(request.getParameter("password"));
		to.setContent(request.getParameter("content"));

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		int flag = dao.boardModifyOk(to);

		request.setAttribute("flag", flag);
		request.setAttribute("seq", to.getSeq());
	}

}
