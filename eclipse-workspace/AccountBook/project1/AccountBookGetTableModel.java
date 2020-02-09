import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AccountBookGetTableModel extends AbstractTableModel {

	private ArrayList<AccountBookTableTO> datas = null;
	private String[] columnName = new String[] { "날짜", "대분류", "소분류", "금액" };
	private int m_num;
	private String date;

	public AccountBookGetTableModel(int m_num, String date) {
		this.m_num = m_num;
		this.date = date;

		datas = new ArrayList<AccountBookTableTO>();

		MainDAO dao = new MainDAO();

		datas = dao.SearchGetMoney(m_num, date);
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
		AccountBookTableTO to = datas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			result = to.getG_date();
			break;
		case 1:
			result = to.getG_section1();
			break;
		case 2:
			result = to.getG_section2();
			break;
		default:
			result = to.getG_money();
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
