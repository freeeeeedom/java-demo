package demo.base.thread;

import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //查看线程数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //一池 固定线程数量
        ExecutorService fixed = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        //一池 单线程
        ExecutorService single = Executors.newSingleThreadExecutor();
        //一池 多线程
        ExecutorService cached = Executors.newCachedThreadPool();


        /**
         * @Description: 七大参数 常驻线程数 corepoolsize   最大线程数maximumpoolsize
         *               存活时间keepalivetime 时间单位TimeUnit 阻塞队列BlockingQueue 线程工厂threadFactory 失效策略AbortPollicy
         * @author: Nevernow
         * @Date: 2019/4/29 21:05
         */
        ExecutorService custom = new ThreadPoolExecutor(1, 1,
                10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new AbortPolicy());
    }
}
