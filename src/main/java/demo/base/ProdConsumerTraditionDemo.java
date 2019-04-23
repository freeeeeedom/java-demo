package demo.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模型经典版
 * 题目 ：一个初始值为零的变量 两个线程交替操作 一个+1 一个-1，5轮
 */
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        }, "D").start();
    }
}

class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition conditionLock = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            //1.判断
            while (number != 0) {
                //2.等待
                conditionLock.await();
            }
            //3.计算
            System.out.println(Thread.currentThread().getName() + "\t" + (++number));
            //4.通知唤醒
            conditionLock.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            //1.判断
            while (number == 0) {
                //2.等待
                conditionLock.await();
            }
            //3.计算
            System.out.println(Thread.currentThread().getName() + "\t" + (--number));
            //4.通知唤醒
            conditionLock.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}