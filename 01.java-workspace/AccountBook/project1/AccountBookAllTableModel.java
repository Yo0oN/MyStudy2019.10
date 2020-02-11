import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AccountBookAllTableModel extends AbstractTableModel {
	private ArrayList<AccountBookTableTO> datas = null;
	private String[] columnName = new String[] { "날짜", "대분류", "소분류", "금액", "카드/현금" };
	private int m_num;
	private String date;

	public AccountBookAllTableModel(int m_num, String date) {
		this.m_num = m_num;
		this.date = date;

		datas = new ArrayList<AccountBookTableTO>();

		MainDAO dao = new MainDAO();

		datas = dao.SearchAllMoney(m_num, date);
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
			result = to.getDate();
			break;
		case 1:
			result = to.getSection1();
			break;
		case 2:
			result = to.getSection2();
			break;
		case 3:
			result = to.getMoney();
			break;
		default:
			result = to.getCash_card();
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
