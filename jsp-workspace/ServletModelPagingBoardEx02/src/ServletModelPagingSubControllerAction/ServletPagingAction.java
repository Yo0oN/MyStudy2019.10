package ServletModelPagingSubControllerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletPagingAction {
	public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
