package zipSearchComboBox;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class SidoComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<ZipcodeTO> sidos;
    
	public SidoComboBoxModel() {
		// TODO Auto-generated constructor stub
		ZipcodeDAO dao = new ZipcodeDAO();
		sidos = dao.listSido();
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return sidos.size();
	}
	    
	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		ZipcodeTO to = sidos.get( index );
		return to.getSido();
	}
}
