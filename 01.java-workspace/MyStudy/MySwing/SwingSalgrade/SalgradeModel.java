package SwingSalgrade;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class SalgradeModel extends AbstractTableModel {
	// 테이블 만드는곳
	private ArrayList<SalgradeTO> datas = null;
	private SalgradeDAO dao = null;
	private SalgradeTO to = null;
	
	// 열 이름
	private String[] colName = new String[] {"grade", "losal", "hisal"};

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		datas = new ArrayList<SalgradeTO>();
		datas = dao.getSalgrade();
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		String result = "";
		to = datas.get(rowIndex);
		switch (columnIndex) {
		case 0 :
			result = to.getGrade();
			break;
		case 1 :
			result = to.getLosal();
			break;
		default :
			result = to.getHisal();
			break;
		}
		return result;
	}

}
