package util;

import java.text.DecimalFormat;

public class FormatEL {
	// 숫자와 포맷형식을 입력하면 해당 형식으로 처리해주는
	// 업무 처리용 머서드
	public static String number(long number, String pattern) {
		DecimalFormat format = new DecimalFormat(pattern);
		return format.format(number);
	}
}
