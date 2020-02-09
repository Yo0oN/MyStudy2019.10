package SwingDeptTable;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class DeptModel extends AbstractTableModel {
	// 테이블 만들어주는곳
	private ArrayList<DeptTO> datas = null;
	// column 이름
	private String[] colName = new String[] { "deptno", "dname", "loc" };

	public DeptModel() {
		// TODO Auto-generated constructor stub
		datas = new ArrayList<DeptTO>();
		
		DeptDAO dao = new DeptDAO();
		
		datas = dao.getDept();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
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
		DeptTO to = datas.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			result = to.getDeptno();
			break;
		case 1:
			result = to.getDname();
			break;
		default:
			result = to.getLoc();
			break;
		}
		return result;
	}

	// column 이름 지정해주기
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colName[column];
	}

}
