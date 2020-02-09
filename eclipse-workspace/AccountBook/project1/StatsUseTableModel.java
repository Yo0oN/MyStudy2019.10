import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class StatsUseTableModel extends AbstractTableModel {
	private ArrayList<StatsTableTO> datas = null;
	private String[] columnName = new String[] { "대분류", "금액" };
	private int m_num;
	private String date;

	public StatsUseTableModel(int m_num, String date) {
		this.m_num = m_num;
		this.date = date;

		datas = new ArrayList<StatsTableTO>();
		MainDAO dao = new MainDAO();

		datas = dao.StatsUseMoney(m_num, date);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = "";
		StatsTableTO to = datas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			result = to.getU_section1();
			break;
		default:
			result = to.getU_money();
			break;
		}
		return result;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnName[column];
	}

}
