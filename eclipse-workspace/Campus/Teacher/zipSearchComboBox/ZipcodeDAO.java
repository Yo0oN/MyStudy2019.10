package zipSearchComboBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipcodeDAO {
	private Connection conn = null;
    
	public ZipcodeDAO() {
		String url = "jdbc:mariadb://192.168.0.24:3306/employees";
		String user = "root";
		String password = "123456";
	          
		try {
			Class.forName( "org.mariadb.jdbc.Driver" );
			this.conn = DriverManager.getConnection( url, user, password );
		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} catch ( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		}
	}
	       
	public ArrayList<ZipcodeTO> listSido() {
		// select distinct sido from zipcode
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	          
		ArrayList<ZipcodeTO> sidos = new ArrayList<ZipcodeTO>();
		try {
			String sql = "select distinct sido from zipcode";
			pstmt = this.conn.prepareStatement( sql );
	              
			rs = pstmt.executeQuery();
	            
			ZipcodeTO tto = new ZipcodeTO();
			tto.setSido( "시도 선택" );
			sidos.add( tto );
			while( rs.next() ) {
				ZipcodeTO to = new ZipcodeTO();
				to.setSido( rs.getString( "sido" ) );
				sidos.add( to );
			}
		} catch( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return sidos;
	}
	    
	public ArrayList<ZipcodeTO> listGugun( String strSido ) {
		// select distinct gugun from zipcode where sido = ?
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	          
		ArrayList<ZipcodeTO> guguns = new ArrayList<ZipcodeTO>();
		try {
			String sql = "select distinct gugun from zipcode where sido = ?";
			pstmt = this.conn.prepareStatement( sql );
			pstmt.setString( 1, strSido );
	              
			rs = pstmt.executeQuery();
			ZipcodeTO tto = new ZipcodeTO();
			tto.setGugun( "구군 선택" );
			guguns.add( tto );
			while( rs.next() ) {
				ZipcodeTO to = new ZipcodeTO();
				to.setGugun( rs.getString( "gugun" ) );
				guguns.add( to );
			}
		} catch( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return guguns;
	}
	       
}
