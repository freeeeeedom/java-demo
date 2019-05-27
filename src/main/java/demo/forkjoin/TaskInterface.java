package demo.forkjoin;

import java.util.List;

/**
 * 任务抽象接口
 * @author: Nevernow
 * @Date: 14:47 2019/5/27
 */
public abstract class TaskInterface<T> {
    abstract List execute(List list);
}
