package demo.base;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者模型经典版
 *  volatile BolckingQueue AtomicInteger
 * 题目 ：一个初始值为零的变量 两个线程交替操作 一个+1 一个-1，5轮
 */
public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) {
        MyData myData = new MyData(new ArrayBlockingQueue(2));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程开始");
            try {
                myData.myProducer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费者程开始");
            try {
                myData.myConsumer();
                System.out.println();
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myData.stop();
    }
}

class MyData {
    private static volatile boolean FLAG = true;
    AtomicInteger number = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyData(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProducer() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = number.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒没有获取到内容，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }
    }

    public void stop() {
        FLAG = false;
    }
}