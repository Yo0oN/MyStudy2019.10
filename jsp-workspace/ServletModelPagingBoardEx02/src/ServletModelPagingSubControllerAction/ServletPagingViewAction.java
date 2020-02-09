package ServletModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServletModelPagingModel.ServletPagingBoardDAO;
import ServletModelPagingModel.ServletPagingBoardTO;

public class ServletPagingViewAction implements ServletPagingAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("View1Action 호출");

		ServletPagingBoardDAO dao = new ServletPagingBoardDAO();
		ServletPagingBoardTO to = new ServletPagingBoardTO();
		String seq = request.getParameter("seq");

		to.setSeq(seq);

		to = dao.boardView(to);
		
		request.setAttribute("to", to);
	}

}
