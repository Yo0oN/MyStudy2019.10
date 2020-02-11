package ServletModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServletModelPagingModel.ServletPagingBoardDAO;
import ServletModelPagingModel.ServletPagingBoardTO;

public class ServletPagingModifyOkAction implements ServletPagingAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("ModifyOk 호출");
		
		ServletPagingBoardDAO dao = new ServletPagingBoardDAO();
		
		ServletPagingBoardTO to = new ServletPagingBoardTO();
		
		String cpage = request.getParameter("cpage");
		String seq = request.getParameter("seq");
		to.setSeq(seq);
		to.setCpage(request.getParameter("cpage"));
		to.setPassword(request.getParameter("password"));
		to.setContent(request.getParameter("content"));
		to.setSubject(request.getParameter("subject"));
		String mail = "";
		if (!request.getParameter("mail1").trim().equals("") && !request.getParameter("mail2").trim().equals("")) {
			mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
		}
		to.setMail(mail);
		
		int flag = dao.boardModifyOk(to);
		
		request.setAttribute("flag", flag);
		request.setAttribute("seq", seq);
		request.setAttribute("cpage", cpage);
	}

}
