package MyClass;

public class JuminCheckEx01Arg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 주민등록번호에서는 맨마지막을 제외하고 첫자리부터 순서대로 X2,3,4...9,2,3,4,5를 한 후
		// 그 수를 모두 더한값을 11로 나눈 나머지를 11에서빼준다. 그리고 다시10으로 나눈것의 나머지가 주민번호의 마지막과 같게 설정되어있다.
		// 주민등록번호가 맞는지 확인해보자.

		// 순서 : 인자를 받아들인다 -> 하나씩 분리한다. -> 분리한것을 int형으로 변경한다 -> 계산해준다.
		int sepResult = 0;
		if (args.length != 1) {
			System.out.println("주민등록번호를 ******-******* 형식으로 입력하세요.");
		} else {
			for (String arg : args) {
				// System.out.println(arg);
				for (int i = 0, j = 2; i < 13; i++, j++) {
					// 하나씩 분리한다.
					String sepString = arg.substring(i, i + 1);
					if (i == 6) {
						continue;
					}
					// System.out.print(sepString);
					// 분리한것을 정수형으로 변경한다.
					int sepID = Integer.parseInt(sepString);
					// System.out.print(sepID);
					// 곱할값이 2에서부터 쭉커지다가 -에서 조건문이 멈추고 올라가기때문에 x8이 넘어가버린다.
					// x9를 x8로 수정해서 계산해주고, x10이되었을때 10대신2를 곱할수있게 바꿔준다.
					if (i == 7) {
						j = 8;
					}
					if (j == 10) {
						j = 2;
					}
					// 각숫자에 순서대로 곱한 후 더한다.
					sepResult += sepID * j;
				}
				// System.out.println(sepResult);
				// 계산해주기
				int checkID = ((11 - (sepResult % 11)) % 10);
				// 마지막숫자빼주기
				int finalID = Integer.parseInt(arg.substring(13));
				if (checkID == finalID) {
					System.out.println("맞습니다.");
				} else {
					System.out.println("다시입력하세요.");
				}
			}
		}

	}

}
