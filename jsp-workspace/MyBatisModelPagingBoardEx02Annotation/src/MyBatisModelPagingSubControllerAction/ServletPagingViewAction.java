package MyBatisModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyBatisModelPagingModel.MyBatisPagingBoardDAO;
import MyBatisModelPagingModel.MyBatisPagingBoardTO;

public class ServletPagingViewAction implements ServletPagingAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("View1Action 호출");

		MyBatisPagingBoardDAO dao = new MyBatisPagingBoardDAO();
		MyBatisPagingBoardTO to = new MyBatisPagingBoardTO();
		String seq = request.getParameter("seq");

		to.setSeq(seq);

		to = dao.boardView(to);
		
		request.setAttribute("to", to);
	}

}
