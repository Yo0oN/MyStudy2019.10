package MyBatisModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyBatisModelPagingModel.MyBatisPagingBoardDAO;
import MyBatisModelPagingModel.MyBatisPagingBoardTO;

public class ServletPagingWriteOkAction implements ServletPagingAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Write1OkAction 호출");

		MyBatisPagingBoardTO to = new MyBatisPagingBoardTO();
		
		to.setSubject(request.getParameter("subject"));
		to.setWriter(request.getParameter("writer"));
		
		String mail = "";
		// 만약 mail1과 mail2가 둘다 들어올경우엔 이메일을 저장하고, 아니면 저장하지 않는다.
		if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
			mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
		}
		to.setMail(mail);
		to.setPassword(request.getParameter("password"));
		to.setContent(request.getParameter("content"));
		to.setWip(request.getRemoteAddr());
		
		MyBatisPagingBoardDAO dao = new MyBatisPagingBoardDAO();
		
		String seq = request.getParameter("seq");
		
		to.setSeq(seq);
		int flag = dao.boardWriteOk(to);
		
		request.setAttribute("flag", flag);
	}

}
