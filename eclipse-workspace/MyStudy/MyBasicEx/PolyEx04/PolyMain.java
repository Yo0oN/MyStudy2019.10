package PolyEx04;

public class PolyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Parseable p = new Parseable() ->추상화된 인터페이스 직접 못부름
		
		Parseable p =new HTMLParser();
		p.parse("test.html");
		
		p = new XMLParser();
		p.parse("test.xml");
		
		
		
	}

}
