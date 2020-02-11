package ExceptionEx;

public class BookExLoginFailException03 extends RuntimeException{
	enum ErrorCode{
		INVALID_ID, INVALID_PASS
	}
	
	private ErrorCode errorCode;
	
	public BookExLoginFailException03 (ErrorCode errorCode, String data) {
		super(data);
		this.errorCode = errorCode;
	}

	@Override
	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		String msg = this.getMessage();
		switch (errorCode) {
		case INVALID_ID :
			msg += ", 아이디를 학인하세요.";
			break;
		case INVALID_PASS :
			msg += "비밀번호를 확인하세요.";
			break;
		}
		return msg;
	}	
}
