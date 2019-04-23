package demo.base;

public class DeadLockDemo {
    public static void main(String[] args) {
        new Thread(new DeadLock("A", "B"), "A").start();
        new Thread(new DeadLock("B", "A"), "B").start();
    }
}

class DeadLock implements Runnable {
    Object lockA;
    Object lockB;

    DeadLock(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "线程当前持有锁：" + lockA + "，尝试获取锁" + lockB);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获取锁" + lockB + "成功");
            }
        }
    }
}
