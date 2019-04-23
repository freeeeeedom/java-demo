package demo.base;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁 cas实现
 */
public class SpinLockDemo {

    static AtomicReference atomicReference = new AtomicReference();

    /**
     * 通过死循环来查看当前atomicReference是不是当前线程 不是则等待
     */
    public static void getlock() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁");
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {
        }
        System.out.println(Thread.currentThread().getName() + "获取锁成功");
    }

    /**
     * 查看atomicReference中的线程是否是当前线程 是的话则设置为空
     */
    public static void unlock() {
        System.out.println(Thread.currentThread().getName() + "解锁");
        atomicReference.compareAndSet(Thread.currentThread(), null);
    }

    /**
     * 自旋锁Demo 通过atomicReference的CAS来改变其值来实现
     * @param args
     */
    public static void main(String[] args) {
        getlock();
        new Thread(() -> {
            getlock();
            unlock();
        }, "t1").start();

        new Thread(() -> {
            getlock();
            unlock();
        }, "t2").start();
        unlock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mission complete");
    }
}
