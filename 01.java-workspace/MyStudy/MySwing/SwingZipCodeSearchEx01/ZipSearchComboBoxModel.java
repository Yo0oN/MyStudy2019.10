package SwingZipCodeSearchEx01;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class ZipSearchComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<String> datas;

	public ZipSearchComboBoxModel(String strDong) {
		// DB에서 받아와 ArrayList에 넣어준다.
		ZipSearchEx03DAO2 dao = new ZipSearchEx03DAO2();
		datas = dao.searchZip(strDong);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return datas.get(index);
	}

}
