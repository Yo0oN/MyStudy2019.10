package SimpleBoard01ActionSubController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleBoard01Write1 implements SimpleBoard01Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Writer1 SubController 호출");

	}

}
