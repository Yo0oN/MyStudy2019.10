package FileEx;
import java.io.File;

public class FileEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//디렉토리
		File f = new File("c://java");
		//c드라이브 안에 들어있는 파일 목록들이 보인다.
//		String[] lists = f.list();
//		for(String list : lists) {
//			System.out.print(list + " ");
//		}

		//디렉토리만 괄호쳐주기
		//isDirectory사용해보자..
		//list에 들은것들을 하나씩 꺼내보며 확인해보자 흠..
//		for (String list : lists) {
//			File sub = new File("c://java", list);
//			if (sub.isDirectory()) {
//				System.out.println("[" + list + "]");
//			} else {
//				System.out.println(list);
//			}			
//		}
		
		File[] listFiles = f.listFiles();
		for(File list : listFiles) {
			if(list.isDirectory()) {
				System.out.println("[" + list.getName() + "]");
			} else {
				System.out.println(list.getName());
			}
		}
	}
}
