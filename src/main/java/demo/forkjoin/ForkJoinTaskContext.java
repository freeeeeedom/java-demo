package demo.forkjoin;

import java.util.List;

public class ForkJoinTaskContext<T> {
    TaskInterface<T> task;

    public ForkJoinTaskContext(TaskInterface task) {
        this.task = task;
    }

    public List execute(List list) {
        return task.execute(list);
    }

}
