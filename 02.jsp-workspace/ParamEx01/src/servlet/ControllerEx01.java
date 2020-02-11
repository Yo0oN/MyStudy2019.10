package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;
import model.View1Model;
import model.View2Model;

/**
 * Servlet implementation class ControllerEx01
 */
@WebServlet("/controller")
public class ControllerEx01 extends HttpServlet {
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
		// 모든 요청을 받아주는 doProcess메소드
		try {
			request.setCharacterEncoding("utf-8");

			String action = request.getParameter("action");

			// 컨트롤러부분
			String url = "";
			Model model = null;

			if (action == null || action.equals("") || action.equals("view1")) {
				// 모델 처리 구간 => 다형성
				model = new View1Model();
				model.execute(request, response);

				url = "/WEB-INF/view1.jsp";
			} else if (action.equals("view2")) {
				// 모델 처리 구간
				model = new View2Model();
				model.execute(request, response);

				url = "/WEB-INF/view2.jsp";
			} else {
				// 모델 처리 구간
				url = "/WEB-INF/error.jsp";
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
