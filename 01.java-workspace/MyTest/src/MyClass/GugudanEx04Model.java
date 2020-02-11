package MyClass;

import javax.swing.table.AbstractTableModel;

public class GugudanEx04Model extends AbstractTableModel {
	private String[][] gugudan = null;
	String[] colName = {
			"\uB2E8", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"
		};

	// 시작단과 끝단을 받아온다.
	public GugudanEx04Model(int start, int end) {
		// 몇단인지 표시할 때 사용할 변수
		int startdan = start;
		
		// 구구단의 열은 10개의고, 행은 끝단-시작단 개이다.		
		gugudan = new String[end-start+1][10];
		// 행. 각 행마다 구구단을 쭉 넣어준다.
		for (int i = 0; i < (end-start+1); i++, startdan++) {
			// 첫번째 열에는 몇단인지를 알려주는값을 넣고,
			gugudan[i][0] = (startdan + "단");
			
			// 두번째 열부터는 값을 넣어준다.
			for (int j = 1; j<10; j++) {
				gugudan[i][j] = (3 * j + "");
			}
		}
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colName[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return gugudan.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return gugudan[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return gugudan[rowIndex][columnIndex];
	}

}
