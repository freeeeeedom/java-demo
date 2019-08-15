package demo.forkjoin;

import demo.base.thread.ThreadPoolDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ForkJoinDemo {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 999; i++) {
            list.add(i);
        }

        try {
            List result = ThreadPoolDemo.ThreadPool.THREAD_POOL.getForkJoinPool().submit(new ForkJoinTask(list, new ForkJoinImpl())).get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
