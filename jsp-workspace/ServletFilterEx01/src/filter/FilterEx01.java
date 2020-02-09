package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEx01 implements Filter {
	private String encoding = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// System.out.println("1. init() 호출");
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("1. 전처리");
		// doFilter를 기준으로 윗부분이 전처리시 사용되는 필터 (클라이언트->서버)
		// doFilter를 통과하여 클라이언트에게 전송되는 페이지가 실행되기 때문에,
		// doFilter메소드를 지우면 해당페이지가 실행되지 않는다.
		// 보통 필터에서는 다국어처리를 많이한다.
		// 사용자가 다국어처리를 바꾸고 싶을 수도 있으니,
		// 인코딩같은것은 클라이언트쪽에서도 수정 가능한 web.xml에서 설정해준다.
		// 그러면 web.xml에서 받아온 파라미터로 인코딩 설정이 가능하고,
		// 사용자의 편리대로 수정 가능하다.
		if (arg0.getCharacterEncoding() == null) {
			arg0.setCharacterEncoding(encoding);
		}
		arg2.doFilter(arg0, arg1);
		// doFilter를 기준으로 아랫부분이 후처리시 사용되는 필터 (클라이언트<-서버)
		//System.out.println("1. 후처리");
	}
}
