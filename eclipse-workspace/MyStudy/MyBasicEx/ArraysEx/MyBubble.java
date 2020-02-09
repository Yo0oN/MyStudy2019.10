package ArraysEx;

import java.util.Random;


public class MyBubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//일단 배열만들어서 방마다 랜덤으로 수가 들어가게 만든다.
		Random r = new Random();
		//배열만들었음	
		int[] array = new int[10];
		//배열의 각 방에 1부터 100까지 랜덤으로 넣어준다.
		for (int i = 0; i<10; i++) {
			array[i] = r.nextInt(100);
		}
		//배열의 각 방에 10부터 0까지 넣어도된다.
//		for(int i = 10, j = 0; j <10; i--, j++) {
//			array[j] = i;
//		}
		//버블 정렬 전의 배열을 뽑아본다.
		System.out.println("버블 정렬 전");
		for (int arr :array) {
			System.out.print(arr + "  ");			
		}
		System.out.println();
		//이제 앞에서부터 하나씩 비교해서 작은수는 앞쪽으로 오게 만들어보자.
		//비교하는동안 값을 잠시 맡아줄 변수를 하나 만들자.
		int temp = 0;
		//반복을 한번 더 하는것은 만약 한번만 반복하면 이것은 각자 앞뒤방의 숫자와만 비교를 한것이기 때문에 완벽하게 오름차순 정렬이 된 것이 아니다.
		//모든 수들이 다른 수들과 전부 한번씩은 만나서 비교해야하므로 안의 반복문을 다시한번 반복한다.
		for (int i = 0; i < array.length-1 ; i++) {
			//계속 방을 바꿔주게 한다.(마지막에 남은 수는 비교할것이 없으니 배열의 길이보다 1이 작아야함.)
			for(int j = 0; j < array.length-1;j++) {
				//만약 j번방이 j+1번 방보다 클경우에는 자리를바꿔준다.
				if(array[j] >array[j+1]) {
					//임시방에 j번방의 수를 잠시 맡기고
					temp = array[j];
					//j번 방에 j+1번방의 내용을 넣는다.
					array[j] = array[j+1];
					//임시방에 맡겨놨던 수를 다시 j+1번 방에 넣는다.
					array[j+1] = temp;
				}
				System.out.println("버블 정렬 중");
				for (int arr : array) {
					System.out.print(arr + "  ");
				}
			}
		}
		System.out.println("\r버블 정렬 후");
		for (int arr : array) {
			System.out.print(arr + "  ");
		}
		//옛날에 모든사람들과 악수하는 횟수 구하는것과 비슷하다.
		//(n-1)+(n-2)+ ... + 1 로 악수횟수 구하기.
		//그렇기 때문에 사실 위의 81번의 반복 중 36번은 할 필요가 없었다.
		//45번만 비교해도 충분히 자리를 전부 바꿀 수 있다.
		//하지만 그 수만큼만 비교하는 방법이 과연 있을까..?
		//일단은 외우기
	}
}
