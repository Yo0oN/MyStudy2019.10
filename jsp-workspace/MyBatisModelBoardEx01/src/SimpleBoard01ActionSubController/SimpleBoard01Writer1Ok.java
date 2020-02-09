package SimpleBoard01ActionSubController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimpleBoard01Model.SimpleBoard01DAO;
import SimpleBoard01Model.SimpleBoard01DAO;
import SimpleBoard01Model.SimpleBoard01TO;

public class SimpleBoard01Writer1Ok implements SimpleBoard01Action {
	// 여기서는 DB와 연결하여 정보를 받아오거나, 저장하거나 한다.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Writer1Ok SubController 호출");

		String mail = "";
		if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
			mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
		}

		SimpleBoard01TO to = new SimpleBoard01TO();
		to.setSubject(request.getParameter("subject"));
		to.setWriter(request.getParameter("writer"));
		to.setMail(mail);
		to.setPassword(request.getParameter("password"));
		to.setContent(request.getParameter("content"));
		to.setWip(request.getRemoteAddr());

		SimpleBoard01DAO dao = new SimpleBoard01DAO();

		int flag = dao.boardWriteOk(to);

		request.setAttribute("flag", flag);
	}

}
