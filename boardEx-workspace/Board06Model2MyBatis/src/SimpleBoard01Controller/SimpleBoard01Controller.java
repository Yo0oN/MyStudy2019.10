package SimpleBoard01Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimpleBoard01ActionSubController.SimpleBoard01Action;
import SimpleBoard01ActionSubController.SimpleBoard01Delete1;
import SimpleBoard01ActionSubController.SimpleBoard01View1;
import SimpleBoard01ActionSubController.SimpleBoard01Write1;
import SimpleBoard01ActionSubController.SimpleBoard01Writer1Ok;
import SimpleBoard01ActionSubController.SimpleBoard01Delete1Ok;
import SimpleBoard01ActionSubController.SimpleBoard01list1;
import SimpleBoard01ActionSubController.SimpleBoard01modify1;
import SimpleBoard01ActionSubController.SimpleBoard01modify1Ok;

/**
 * Servlet implementation class SimpleBoard01Controller
 */
@WebServlet("/Controller")
public class SimpleBoard01Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");

			String action = request.getParameter("action");

			String url = "";

			SimpleBoard01Action baction = null;

			if (action == null || action.equals("") || action.equals("list")) {
				baction = new SimpleBoard01list1();
				baction.execute(request, response);

				url = "/WEB-INF/model2/board_list1.jsp";

			} else if (action.equals("view")) {
				baction = new SimpleBoard01View1();
				baction.execute(request, response);

				url = "/WEB-INF/model2/board_view1.jsp";

			} else if (action.equals("write")) {
				baction = new SimpleBoard01Write1();
				baction.execute(request, response);

				url = "/WEB-INF/model2/board_write1.jsp";

			} else if (action.equals("write_ok")) {
				baction = new SimpleBoard01Writer1Ok();
				baction.execute(request, response);

				url = "/WEB-INF/model2/board_write1_ok.jsp";

			} else if (action.equals("modify")) {
				baction = new SimpleBoard01modify1();
				baction.execute(request, response);

				url = "/WEB-INF/model2/board_modify1.jsp";

			} else if (action.equals("modify_ok")) {
				baction = new SimpleBoard01modify1Ok();
				baction.execute(request, response);

				url = "/WEB-INF/model2/board_modify1_ok.jsp";

			} else if (action.equals("delete")) {
				baction = new SimpleBoard01Delete1();
				baction.execute(request, response);

				url = "/WEB-INF/model2/board_delete1.jsp";
			} else if (action.equals("delete_ok")) {
				baction = new SimpleBoard01Delete1Ok();
				baction.execute(request, response);

				url = "/WEB-INF/model2/board_delete1_ok.jsp";

			} else {
				url = "/WEB-INF/error/jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (UnsupportedEncodingException e) {

		} catch (ServletException e) {

		} catch (IOException e) {

		}
	}
}
