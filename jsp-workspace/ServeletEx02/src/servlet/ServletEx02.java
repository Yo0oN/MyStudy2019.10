package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx02
 */
@WebServlet(urlPatterns = { "/ex02" }, initParams = {
		@WebInitParam(name = "user", value = "tester"),
		@WebInitParam(name = "password", value = "123456") })
public class ServletEx02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String user = null;
	String password = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.user = config.getInitParameter("user");
		this.password = config.getInitParameter("password");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(user + ": " + password);
	}
}
