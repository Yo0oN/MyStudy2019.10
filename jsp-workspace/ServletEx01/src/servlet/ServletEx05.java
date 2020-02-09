package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 여러페이지의 데이터들을 처리할 수 있다. 재활용
@WebServlet({"*.daum", "*.naver"})
public class ServletEx05 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		this.doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		this.doProcess(req, resp);
	}

	// doGet과 doPost를 통합해주는 메서드
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// dopost의 내용을 이곳에 넣는다. + 다국어 처리 해줄것

		req.setCharacterEncoding("utf-8");

		String data = req.getParameter("data");

		resp.setContentType("text/html;charset=utf-8");

		StringBuffer html = new StringBuffer();

		html.append("<!DOCTYPE html>");
		html.append("<head>");
		html.append("<meta charset='utf-8'>");
		html.append("</head>");
		html.append("<body>");
		html.append("doPost 호출 : " + data);
		html.append("</body>");
		html.append("</html>");

		PrintWriter out = resp.getWriter();
		out.println(html);
	}
}
