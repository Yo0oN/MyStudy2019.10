package SwingZipCodeTableEx;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import JDBCEx.ZipcodeTO;

public class ZipCodeModel extends AbstractTableModel {
	// DB에서 받아온 데이터를 테이블로 만들어 UI로 보내주는곳
	
	// DAO에서 받아올 데이터를 저장해줄 ArrayList
	private ArrayList<ZipcodeTO> datas = null;
	
	// 열 이름
	private String[] columnName = new String[]
			{"ZipCode", "sido", "gugun", "dong", "ri", "bunji", "seq"};

	public ZipCodeModel() {
		// TODO Auto-generated constructor stub
		datas = new ArrayList<ZipcodeTO>();
		ZipCodeDAO zcdao = new ZipCodeDAO();
		
		// data에 DB에서 받아온 내용 넣어줌
		datas = zcdao.selectZipCode();
	}
	
	// 행 길이
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	// 열 길이
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	// 행과 열에 데이터 넣어주기
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		String result = "";
		ZipcodeTO to = datas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			result = to.getZipcode();
			break;
		case 1:
			result = to.getSido();
			break;
		case 2:
			result = to.getGugun();
			break;
		case 3:
			result = to.getDong();
			break;
		case 4:
			result = to.getRi();
			break;
		case 5:
			result = to.getBunji();
			break;
		default :
			result = to.getSeq();
			break;
		}
		return result;
	}
	
	// column 이름 설정해주기
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnName[column];
	}

}
