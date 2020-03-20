package MyBatisModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyBatisModelPagingModel.MyBatisPagingBoardDAO;
import MyBatisModelPagingModel.MyBatisPagingBoardTO;

public class ServletPagingModifyAction implements ServletPagingAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Modify1Action 호출");
		
		MyBatisPagingBoardDAO dao = new MyBatisPagingBoardDAO();
		
		MyBatisPagingBoardTO to = new MyBatisPagingBoardTO();
		to.setCpage(request.getParameter("cpage"));
		to.setSeq(request.getParameter("seq"));
		to = dao.boardModify(to);
		
		request.setAttribute("to", to);
	}

}
