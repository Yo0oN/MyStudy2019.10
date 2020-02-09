package SwingEx01;
import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxModel extends DefaultComboBoxModel<String> {
	private String[] datas = null;

	public CustomComboBoxModel() {
		datas = new String[] { "사과", "수박", "딸기", "키위" };
	}
	
	// 데이터의 길이를 알려준다.
	@Override
	public int getSize() {
		System.out.println("getSize() 호출");
		return datas.length;
	}
	
	// 데이터를 가져오는 방법
	@Override
	public String getElementAt(int index) {
		System.out.println("getElementAt() 호출");
		return datas[index];
	}
}
