package SimpleBoard01ActionSubController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SimpleBoard01Action {
	public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
