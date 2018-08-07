package com.george.datastructure.queue;

import java.util.Date;
import java.util.concurrent.*;

public class BlockingQueueTest{

	/**
	 * 篮子
	 * @author georgechmr@gmail.com
	 * @date 2018/7/5 15:42
	 */
	public static class Basket {
		/**
		 * 容量为3的篮子
		 */
		BlockingQueue<String> basket = new ArrayBlockingQueue<>(3);

		/**
		 * 生产者
		 * @throws InterruptedException
		 */
		public void produce() throws InterruptedException {
			basket.put("An apple");
		}

		/**
		 * 消费者
		 * @return
		 * @throws InterruptedException
		 */
		public String consume() throws InterruptedException {
			return basket.take();
		}

		public int getAppleNumber() {
			return basket.size();
		}
	}

	public static void testBasket() throws InterruptedException {
		final Basket basket = new Basket();

		class Producer implements Runnable {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("生产者准备生产苹果：" + new Date());
						basket.produce();
						System.out.println("生产者生产苹果完毕：" + new Date());
						System.out.println("生产完后有苹果：" + basket.getAppleNumber() + "个");

						Thread.sleep(300);
					}
				} catch (InterruptedException e) {

				}
			}
		}

		class Consumer implements Runnable {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("消费者准备消费苹果：" + new Date());
						basket.consume();
						System.out.println("消费者消费苹果完毕：" + new Date());
						System.out.println("消费完后有苹果：" + basket.getAppleNumber());

						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {

				}
			}
		}

		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));
		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		System.out.println(executor.getQueue());
		System.out.println(executor.getActiveCount());

		executor.execute(() -> System.out.println("执行第一次！"));
		System.out.println(executor.getQueue());
		System.out.println(executor.getActiveCount());
		executor.execute(() -> System.out.println("执行第二次"));

		executor.shutdown();

		System.out.println(executor.getQueue());
		System.out.println(executor.getActiveCount());
	}

	public static void main(String [] args) throws InterruptedException {
		BlockingQueueTest.testBasket();
	}
}
