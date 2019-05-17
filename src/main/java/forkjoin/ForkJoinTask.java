package forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTask extends RecursiveTask<List> {

    private final static int DEFAULT_SIZE = 200;
    private static TaskInterface task;
    private static int size = 0;
    private List list;

    public ForkJoinTask(List list, int size, TaskInterface task) {
        this.list = list;
        ForkJoinTask.size = size;
        ForkJoinTask.task = task;
    }

    public ForkJoinTask(List list, TaskInterface task) {
        this(list, DEFAULT_SIZE, task);
    }

    private ForkJoinTask(List list) {
        this.list = list;
    }

    @Override
    protected List compute() {
        if (list.size() < size) {
            return task.execute(list);
        }
        int size = list.size();
        ForkJoinTask task1 = new ForkJoinTask(list.subList(0, size / 2));
        ForkJoinTask task2 = new ForkJoinTask(list.subList(size / 2, size));

        //两个任务并发执行起来
        invokeAll(task1, task2);

        //执行任务并返回结果
        List join1 = task1.join();
        List join2 = task2.join();
        join1.addAll(join2);
        return join1;
    }
}
