package SwingEx01;
import javax.swing.AbstractListModel;

public class CustomJListModelEx01 extends AbstractListModel<String> {
	private String[] datas = null;
	
	public CustomJListModelEx01() {
		datas = new String[] {"사과","딸기", "수박", "키위", "사과","딸기", "수박", "키위", "사과","딸기", "수박", "키위", "사과","딸기", "수박", "키위"};
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return datas.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return datas[index];
	}

}
