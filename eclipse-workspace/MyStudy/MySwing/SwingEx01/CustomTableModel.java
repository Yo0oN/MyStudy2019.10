package SwingEx01;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {

	private String[][] datas = null;

	public CustomTableModel() {
		datas = new String[][] {
		{"1", "2", "3", "4", "5"},
		{"6", "7", "8", "9", "10"},
		{"11", "12", "13", "14", "15"},
		{"16", "17", "18", "19", "20"},
		};
	}

	@Override
	public int getRowCount() {
		// 행 개수(datas)
		return datas.length;
	}

	@Override
	public int getColumnCount() {
		// 열 개수 
		return datas[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// 행과 열을 불러오기
		return datas[rowIndex][columnIndex];
	}

}
