package zipSearchComboBox;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class GugunComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<ZipcodeTO> guguns;
    
	public GugunComboBoxModel(String sido) {
		// TODO Auto-generated constructor stub
		ZipcodeDAO dao = new ZipcodeDAO();
		guguns = dao.listGugun(sido);
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return guguns.size();
	}
	    
	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		ZipcodeTO to = guguns.get( index );
		return to.getGugun();
	}
}
