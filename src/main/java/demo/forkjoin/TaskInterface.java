package demo.forkjoin;

import java.util.List;

public abstract class TaskInterface<T> {
    abstract List execute(List list);
}
