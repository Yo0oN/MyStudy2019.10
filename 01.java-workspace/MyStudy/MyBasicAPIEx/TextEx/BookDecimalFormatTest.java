package TextEx;
import java.text.DecimalFormat;
import java.text.ParseException;

public class BookDecimalFormatTest {

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub
		double orgNum = 1234.5;
		DecimalFormat df = new DecimalFormat("￦#,###.#");
		System.out.println(df.format(orgNum));
		/*
		String orgStr = "￦1,234,5";
		double parsed = (double) df.parse(orgStr);
		System.out.println(parsed);
		*/
		try {
			String orgStr = "￦1,234.5";
			double parsed = (double) df.parse(orgStr);
			System.out.println(parsed);
			
			df.applyPattern("#.#%");
			System.out.println(df.format(parsed));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}
}
