package SwingEmpTableEx;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class EmpTableModel extends AbstractTableModel {
	// 생성자에다가는 DB에 접근
	// table - 행과 열을 가진 2차원임
	// 2차원배열 / ArrayList<ArrayList> / ArrayList<TO>
	// ArrayList<TO>를 쓰자 -> TO용 클래스 하나 더만들어야함.

	private ArrayList<EmpTO> datas = null;
	private String[] columnName = new String[]
			{"empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno"};

	public EmpTableModel() {
		datas = new ArrayList<EmpTO>();
		
		EmpDAO dao = new EmpDAO();
		// EmpDAO의 selectEmp메소드를 실행하여 datas변수에 데이터를 넣어준다.
		datas = dao.selectEmp();

	}
	// 행의 개수
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}
	// 열의 개수
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}
	
	// 행과 열의 위치값으로 그 값을 가져온다.
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		String result = "";
		EmpTO to = datas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			result = to.getEmpno();
			break;
		case 1:
			result = to.getEname();
			break;
		case 2:
			result = to.getJob();
			break;
		case 3:
			result = to.getMgr();
			break;
		case 4:
			result = to.getHiredate();
			break;
		case 5:
			result = to.getSal();
			break;
		case 6:
			result = to.getComm();
			break;
		default:
			result = to.getDeptno();
			break;
		}
		return result;
	}
	
	// 컬럼이름을 바꿔준다.
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnName[column];
	}

}
