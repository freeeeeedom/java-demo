package demo.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * 1.队列
 * 概念 fifo 必然有序
 * 2.阻塞队列
 * 概念 队满时put阻塞 队空时take阻塞
 * 2.1 阻塞队列有没有好的一面
 * 2.2 不得不阻塞，如何管理
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
    }

    private static void synchronousQueue() {
        BlockingQueue synchBlockingQueue = new SynchronousQueue();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put 1\n");
                synchBlockingQueue.put(1);
                System.out.println(Thread.currentThread().getName() + " put 2\n");
                synchBlockingQueue.put(2);
                System.out.println(Thread.currentThread().getName() + " put 3\n");
                synchBlockingQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " take " + synchBlockingQueue.take() + "\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }

    private static void arrayBlockingQueue() {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        new Thread(() -> {
            try {
                blockingQueue.put(4);
                blockingQueue.put(5);
                blockingQueue.put(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        while (Thread.activeCount() > 2) {
        }
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }
}
