package MyBatisModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyBatisModelPagingModel.MyBatisPagingBoardDAO;
import MyBatisModelPagingModel.MyBatisPagingBoardTO;

public class ServletPagingWriteAction implements ServletPagingAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Write1Action 호출");
	}

}
