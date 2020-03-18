package HashSetEx;
import java.util.HashSet;
import java.util.Set;

public class BookHashSetTest {
	//Object가 들어가는 Set계열의 hset를 만듬
	Set<Object> hset = new HashSet<Object>();
	//Object가 들어가도록 설정했으니 아무거나 다 들어간다.
	private void addMethod() {
		hset.add(Integer.valueOf(1));
		//중복데이터가 들어가서 Hello하나는 삭제된다.
		hset.add("Hello");
		hset.add("Hello");
		hset.add(null);
		hset.add(1);
		//다른 클래스인 BookPhone의 생성자를 불러온다.
		hset.add(new BookPhone("010-000-1234"));
		//다른 클래스인 BookPhone의 생성자를 불러온다.
		//위의 값과 같아보이지만 set이 구분을 못함.519~521쪽을 읽어보자.
		hset.add(new BookPhone("010-000-1234"));
		System.out.println("데이터 추가 결과 : " + hset);		
	}
	
	private void retrieveMethod() {
		System.out.println("데이터 개수 : "+ hset.size());
		//Object로 내용을 출력하기때문에 데이터종류가 뭐가들어있던 상관없이 향상된 for문 사용 가능
		for(Object sobj : hset) {
			System.out.println("데이터 조회 :"+ sobj);
		}
	}
	
	public void removeMethod() {
		hset.remove("Hello");
		System.out.println("데이터 삭제 결과 : " + hset);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookHashSetTest hst = new BookHashSetTest();
		hst.addMethod();
		hst.retrieveMethod();
		hst.removeMethod();
	}
}
