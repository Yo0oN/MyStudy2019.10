package MyBatisModelPagingController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyBatisModelPagingSubControllerAction.ServletPagingAction;
import MyBatisModelPagingSubControllerAction.ServletPagingDeleteAction;
import MyBatisModelPagingSubControllerAction.ServletPagingDeleteOkAction;
import MyBatisModelPagingSubControllerAction.ServletPagingListAction;
import MyBatisModelPagingSubControllerAction.ServletPagingModifyAction;
import MyBatisModelPagingSubControllerAction.ServletPagingModifyOkAction;
import MyBatisModelPagingSubControllerAction.ServletPagingViewAction;
import MyBatisModelPagingSubControllerAction.ServletPagingWriteAction;
import MyBatisModelPagingSubControllerAction.ServletPagingWriteOkAction;

/**
 * Servlet implementation class ServletPagingBoardController
 */
@WebServlet("*.do")
public class MyBatisPagingBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			
			// 클라이언트가 보낸 요청의 URL에서 URI만 따로 뽑은 후,
			// 그 URI에서 다시 경로를 제외한 *.do부분만 얻는다.
			String path = request.getRequestURI().replace(request.getContextPath(), "");

			String url = "";

			ServletPagingAction baction = null;

			// *.do부분이 /*.do(=최초요청이거나) list.do로들어오면
			// 첫번째 if가 실행된다.
			if (path.equals("/*.do") || path.equals("/list.do")) {
				baction = new ServletPagingListAction();

				baction.execute(request, response);

				url = "/WEB-INF/paging1/board_list1.jsp";

			} else if (path.equals("/view.do")) {
				baction = new ServletPagingViewAction();
				baction.execute(request, response);

				url = "/WEB-INF/paging1/board_view1.jsp";

			} else if (path.equals("/write.do")) {
				baction = new ServletPagingWriteAction();
				baction.execute(request, response);

				url = "/WEB-INF/paging1/board_write1.jsp";

			} else if (path.equals("/writeOk.do")) {
				baction = new ServletPagingWriteOkAction();
				baction.execute(request, response);

				url = "/WEB-INF/paging1/board_write1_ok.jsp";

			} else if (path.equals("/modify.do")) {
				baction = new ServletPagingModifyAction();
				baction.execute(request, response);

				url = "/WEB-INF/paging1/board_modify1.jsp";

			} else if (path.equals("/modifyOk.do")) {
				baction = new ServletPagingModifyOkAction();
				baction.execute(request, response);

				url = "/WEB-INF/paging1/board_modify1_ok.jsp";
			} else if (path.equals("/delete.do")) {
				baction = new ServletPagingDeleteAction();
				baction.execute(request, response);

				url = "/WEB-INF/paging1/board_delete1.jsp";

			} else if (path.equals("/deleteOk.do")) {
				baction = new ServletPagingDeleteOkAction();
				baction.execute(request, response);

				url = "/WEB-INF/paging1/board_delete1_ok.jsp";
			} else {
				url = "/WEB-INF/paging1/error.jsp";
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			System.out.println("error : " + e.getMessage());
		} catch (ServletException e) {
			System.out.println("error : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("error : " + e.getMessage());
		}
	}
}
