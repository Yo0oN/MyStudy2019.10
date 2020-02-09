package MyBatisModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyBatisModelPagingModel.MyBatisPagingBoardDAO;
import MyBatisModelPagingModel.MyBatisPagingBoardTO;

public class ServletPagingDeleteAction implements ServletPagingAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Delete1Action 호출");
		
		MyBatisPagingBoardDAO dao = new MyBatisPagingBoardDAO();
		MyBatisPagingBoardTO to = new MyBatisPagingBoardTO();
	
		to.setCpage(request.getParameter("cpage"));
		to.setSeq(request.getParameter("seq"));
		
		to = dao.boardDelete(to);
		
		request.setAttribute("to", to);
	}
}
