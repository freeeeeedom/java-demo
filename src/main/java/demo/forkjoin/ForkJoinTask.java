package demo.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * 通过索引拆分list ForkJoin模式
 *
 * @author: Nevernow
 * @Date: 14:48 2019/5/27
 */
public class ForkJoinTask extends RecursiveTask<List> {

    private final static int DEFAULT_SIZE = 200;
    private static TaskInterface task;
    private static int size = 0;
    private static List list;
    /**
     * 开始位置索引
     *
     * @author: Nevernow
     * @Date: 2019/5/27 14:43
     */
    private int start;
    /**
     * 开始位置索引
     *
     * @author: Nevernow
     * @Date: 2019/5/27 14:43
     */
    private int end;


    public ForkJoinTask(List list, int start, int end, int size, TaskInterface task) {
        ForkJoinTask.list = list;
        this.start = start;
        this.end = end;
        ForkJoinTask.size = size;
        ForkJoinTask.task = task;
    }

    public ForkJoinTask(List list, TaskInterface task) {
        this(list, 0, list.size(), DEFAULT_SIZE, task);
    }

    private ForkJoinTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected List compute() {
        List runList = list.subList(start, end);
        System.out.println("start:" + start);
        System.out.println("end:" + end);
        if (runList.size() < size) {
            return task.execute(runList);
        }
        int mid = (end - start) / 2 + start;
        ForkJoinTask task1 = new ForkJoinTask(start, mid);
        ForkJoinTask task2 = new ForkJoinTask(mid, end);

        //两个任务并发执行
        invokeAll(task1, task2);

        //执行任务并返回结果
        List join1 = task1.join();
        List join2 = task2.join();
        join1.addAll(join2);
        return join1;
    }
}
