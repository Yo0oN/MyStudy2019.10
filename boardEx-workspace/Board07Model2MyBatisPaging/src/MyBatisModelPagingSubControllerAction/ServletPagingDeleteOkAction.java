package MyBatisModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyBatisModelPagingModel.MyBatisPagingBoardDAO;
import MyBatisModelPagingModel.MyBatisPagingBoardTO;

public class ServletPagingDeleteOkAction implements ServletPagingAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Delete1OkAction 호출");

		MyBatisPagingBoardDAO dao = new MyBatisPagingBoardDAO();
		MyBatisPagingBoardTO to = new MyBatisPagingBoardTO();

		to.setSeq(request.getParameter("seq"));
		to.setPassword(request.getParameter("password"));

		int flag = dao.boardDeleteOk(to);

		request.setAttribute("flag", flag);
	}

}
