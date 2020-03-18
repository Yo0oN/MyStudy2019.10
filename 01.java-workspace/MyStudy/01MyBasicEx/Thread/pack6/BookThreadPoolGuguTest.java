package Thread.pack6;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BookThreadPoolGuguTest {
	//int형 배열 안에 배열을 넣어줌 각각 방이 9개씩있음
	private static int[][] gugudan = new int[9][9];
	private static int dans = 0;
		
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int processCnt = Runtime.getRuntime().availableProcessors();
		System.out.println("VM에서 운용 가능한 프로세서 개수 : " + processCnt);
		ExecutorService es = Executors.newFixedThreadPool(processCnt);
		System.out.println("작업 시작 전 : " + es);
		/*아래의 식은 람다식. 아직안배움..
		Callable<String> callable = () -> {
			int dan = ++dans;
			for (int i = 1; i < 10 ; i++) {
				gugudan[dan - 1][i - 1] = dan*1;
			}
			return dan + "작업 완료, " + Thread.currentThread().getName();
		};
		*/
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				int dan = ++dans;
				for (int i = 1; i < 10 ; i++) {
					gugudan[dan - 1][i - 1] = dan*1;
				}
				return dan + "작업 완료, " + Thread.currentThread().getName();
			}
		};
		for (int i = 0 ; i < 9 ; i++) {
			Future<String> guguFuture = es.submit(callable);
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println(guguFuture.get());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		Thread.sleep(1000*5);
		System.out.println("작업 종료 후 : " + es);
		for(int[] dans : gugudan) {
			for (int num : dans) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}
		es.shutdown();
	}

}
