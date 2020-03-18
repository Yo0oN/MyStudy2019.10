package SwingEx01;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxModel02 extends DefaultComboBoxModel<String> {
	private ArrayList<String> datas;
	
	public CustomComboBoxModel02() {
		// TODO Auto-generated constructor stub
		datas = new ArrayList<String>();
		datas.add("사과");
		datas.add("수박");
		datas.add("딸기");
		datas.add("키위");
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
