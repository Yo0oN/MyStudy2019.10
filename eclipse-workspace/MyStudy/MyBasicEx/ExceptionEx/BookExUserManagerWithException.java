package ExceptionEx;

public class BookExUserManagerWithException {
	public boolean login(String id, String pass) {
		if(!id.equals("hong")) {
			throw new BookExLoginFailException03(BookExLoginFailException03.ErrorCode.INVALID_ID, id);
		} else if (!pass.equals("1234")) {
			throw new BookExLoginFailException03(BookExLoginFailException03.ErrorCode.INVALID_PASS, pass);
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookExUserManagerWithException userManager = new BookExUserManagerWithException();
		try {
			//boolean result = userManager.login("hong", "1234");
			boolean result = userManager.login("hong2", "1234");
			System.out.printf("로그인 성공 여부: %b%n", result);
		} catch(BookExLoginFailException03 e) {
			System.out.printf("예외 처리 : %s%n", e.getLocalizedMessage());
		}
	}

}
