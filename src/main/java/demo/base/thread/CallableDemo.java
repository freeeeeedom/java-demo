package demo.base.thread;

import java.util.concurrent.*;

class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("123");
    }
}

class MyThread2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "123";
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> task = new FutureTask<>(new MyThread2());
        new Thread(task).start();
        System.out.println("callable.get会阻塞");
        System.out.println(task.get(10, TimeUnit.SECONDS));
        System.out.println("complete");
    }


}
