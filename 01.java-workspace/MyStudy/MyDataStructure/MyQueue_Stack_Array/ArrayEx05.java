package MyQueue_Stack_Array;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayEx05 {
	// 한 해의 경과 일 수 구하기 + 남은 일 수 구하기
	static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } // 윤년
	};

	// 해당 년도가 평년이면 0, 윤년이면 1을 반환한다.
	// 참고로 년도가 4로 나누어떨어지면 윤년, 100으로 나누어떨어지면 평년, 400으로 나누어떨어지면 윤년이다.
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	static int dayOfYear(int y, int m, int d) {
		// 1월일경우 반복문에 들어가지 않고 바로 일수를 출력해준다.
		while (m > 1) {
			// 2월부터는 반복문에 들어온다.
			// m달 전까지의 일수를 d에 더해준다.
			m--;
			d += mdays[isLeap(y)][m - 1];
		}

		return d;
	}

	static int leftDayOfYear(int y, int m, int d) {
		// 현재 달의 남은 일를 구한다
		int leftDay = (mdays[isLeap(y)][m - 1] - d);
		// 12월부터 현재의 다음달까지 일수를 더해준다.
		for (int i = 11; i > m - 1; i--) {
			leftDay += mdays[isLeap(y)][i];
		}
		return leftDay;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("년 : ");
			int year = sc.nextInt();

			System.out.print("월 : ");
			int month = sc.nextInt();

			System.out.print("일 : ");
			int day = sc.nextInt();

			// 만약 일수가 이상하다면 에러 발생
			if (day > mdays[isLeap(year)][month - 1]) {
				throw new DayOut();
			}

			System.out.println(dayOfYear(year, month, day) + "일이 경과하였습니다.");
			System.out.println(leftDayOfYear(year, month, day) + "일이 남았습니다.");
		} catch (InputMismatchException e) {
			// 숫자가 아닌 다른것이 들어오면 에러 발생
			System.out.println("숫자만 입력해 주세요.");
		} catch (ArrayIndexOutOfBoundsException e) {
			// 12월 보다 큰 수가 들어온다면 에러 발생
			System.out.println("월은 12월까지만 입력해주세요.");
		} catch (Exception e) {
		}
	}
}
