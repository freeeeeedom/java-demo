package demo.base;

class Phone {
    public volatile int number;

    public void addnumber() {
        this.number = 60;
    }

    public void add1() {
        this.number++;
    }
}

/**
 * volatile的三大特性验证
 *  1.可见性
 *  2.不保证原子性
 *  3.禁止指令重排
 */
public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {
        volatileNotAtomic();
    }

    /**
     * 证明volatile不保证原子性
     * 如果不加保证原子性结果应该是20000
     */
    private static void volatileNotAtomic() {
        Phone phone = new Phone();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    phone.add1();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {

        }
        System.out.println(phone.number);
    }

    /**
     * 证明volatile可见性
     * 如果不加volatile则线程发生改变不会通知其他线程 此程序不会完结
     */
    private static void volatileView() {
        Phone phone = new Phone();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 查看number" + phone.number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phone.addnumber();
            System.out.println(Thread.currentThread().getName() + "\t 修改number" + phone.number);
        }, "t1").start();
        while (phone.number == 0) {
        }
        System.out.println("mission complete");
    }
}
