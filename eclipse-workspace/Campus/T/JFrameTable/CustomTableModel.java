package JFrameTable;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
	
	private ArrayList<ArrayList<String>> datas = null;

	public CustomTableModel(String tableName) {
		// TODO Auto-generated constructor stub
		
		TableDAO dao = new TableDAO(tableName);
		datas = dao.selectTable();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return datas.get(0).size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		ArrayList<String> data = datas.get(rowIndex);
		return data.get(columnIndex);
	}	
}








