package io.file;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadExecutorTest t = new ThreadExecutorTest(3);
		for (int i = 0; i < 20; i++) {
			t.exc(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("线程" + Thread.currentThread().getName() + "帮我干活");
				}
			});
		}
	}
}
