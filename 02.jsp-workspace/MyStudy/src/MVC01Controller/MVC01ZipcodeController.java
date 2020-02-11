package MVC01Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC01Model2.MVC01ZipcodeModel;
import MVC01Model2.MVC01ZipcodeView;
import MVC01Model2.MVC01Zipcode_ok_View;

/**
 * Servlet implementation class MVC01ZipcodeController
 */
@WebServlet("/MVC01ZipcodeController")
public class MVC01ZipcodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// 처음 서버가 실행되고 클라이언트가 요청을하면 이곳에서 페이지를 띄워서 보여준다.
		// 처음에는 action파라미터에 아무것도 들어있지 않을테니,
		// 검색창인 zipcode.jsp가 먼저 보인다.
		// 그 후 검색버튼을 누르면 MVC01ZipcodeController인 이곳으로 넘어온다.
		// 이곳에서는 넘어온 값에 맞게 다시 조건문에서 확인을 한다.
		// 정상적으로 전송되었으면 action에 대한 값이 넘어왔을 테니 다음페이지인 ok페이지로 넘어간다.
		// ok페이지로 넘어가기전 Model로 간 후 들어가 값을 넘겨주고
		// ok페이지는 ok_View페이지에 담겨있는 값을 가져온다.
		try {
			request.setCharacterEncoding("utf-8");

			String action = request.getParameter("action");

			String url = "";
			MVC01ZipcodeModel model = null;

			if (action == null || action.equals("") || action.equals("zipcode")) {
				model = new MVC01ZipcodeView();
				model.execute(request, response);

				url = "/MyServlet/MVC01/zipcode.jsp";

			} else if (action.equals("zipcode_ok")) {
				model = new MVC01Zipcode_ok_View();

				model.execute(request, response);
				url = "/MyServlet/MVC01/zipcode_ok.jsp";

			} else {
				url = "/MyServlet/MVC01/zipcode_error.jsp";

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
