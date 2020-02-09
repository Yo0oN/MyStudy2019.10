package MVC01Model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC01Model1.MVC01ZipcodeDAO;
import MVC01Model1.MVC01ZipcodeTO;

public class MVC01Zipcode_ok_View implements MVC01ZipcodeModel {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// System.out.println("zipcode_ok 호출");
		// System.out.println("동이름 : " + request.getParameter("dong"));

		String strDong = request.getParameter("dong");

		MVC01ZipcodeDAO dao = new MVC01ZipcodeDAO();
		ArrayList<MVC01ZipcodeTO> zipcodeLists = dao.zipcodeList(strDong);

		for (MVC01ZipcodeTO to : zipcodeLists) {
			System.out.println(to.getSeq());
		}

		request.setAttribute("data", "새로운 데이터");
	}

}
