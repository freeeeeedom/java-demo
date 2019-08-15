package demo.forkjoin;

import java.util.ArrayList;
import java.util.List;

public class ForkJoinImpl extends TaskInterface {
    @Override
    List execute(List list) {
        List res = new ArrayList();
        list.parallelStream().forEach(item -> res.add((Integer) item * 2));
        return res;
    }
}
