package learn_stack_queue;

import java.util.Stack;

// 수평 직선에 탑 N대를 세웠습니다.

// 모든 탑의 꼭대기에는 신호를 송/수신하는 장치를 설치했습니다.
// 발사한 신호는 신호를 보낸 탑보다 높은 탑에서만 수신합니다.
// 또한, 한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.
// 예를 들어 높이가 6, 9, 5, 7, 4인 다섯 탑이 왼쪽으로 동시에 레이저 신호를 발사합니다.
// 그러면, 탑은 다음과 같이 신호를 주고받습니다.
// 높이가 4인 다섯 번째 탑에서 발사한 신호는 높이가 7인 네 번째 탑이 수신하고, 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신합니다.
// 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신할 수 없습니다.
//   heights		return
// [6,9,5,7,4]		[0,0,2,2,4]
// [3,9,9,3,5,7,2]	[0,0,0,3,3,3,6]
// [1,5,3,6,7,6,5]	[0,0,2,0,0,5,6]

// 스택에 높이들이 담긴 배열을 차례대로 넣고 뒤에서부터 빼면서 다음뺀것이 이전 뺀것보다 크다면
// 결과의 마지막에서부터 값을 담아준다.
public class Tower {
	public static int[] solution(int[] heights) {
		// 정답배열의 길이는 heights의 길이와 같다.
		int[] answer = new int[heights.length];

		// 탑의 높이가 담긴 배열의 마지막부터, 1번방까지 거꾸로 살펴본다.
		for (int i = heights.length - 1; i >= 1; i--) {
			// 방을 하나씩 볼때마다 현재 기준값의 앞방들을 살펴본다.
			for (int j = i - 1; j >= 0; j--) {
				// a에는 현재 수신을 보내는 기준탑이들어가고
				int a = heights[i];
				// b에는 a의 앞에있는 탑들이 들어간다.
				int b = heights[j];
				// 만약 a <b라면 정답배열에 큰 탑을 넣어주고 다음 반복으로 넘어간다.
				if (a < b) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] q = { 6, 9, 5, 7, 4 };
		int[] answer = Tower.solution(q);
		for (int k : answer) {
			System.out.print(k + "/");
		}
	}

}
