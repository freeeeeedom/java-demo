package demo.java8;

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock 用于支持基于容量的锁
 * DoubleAccumulator
 * DoubleAdder
 * LongAccumulator
 * LongAdder
 * @author: Nevernow
 * @Date: 17:33 2019/8/13
 */ 
public class JUCDemo {
    public static void main(String[] args) {
        StampedLock lock = new StampedLock();
        lock.tryConvertToReadLock(10000);
        DoubleAccumulator doubleAccumulator = new DoubleAccumulator((left, right) -> left * right, 2);
        doubleAccumulator.accumulate(21);
        DoubleAdder doubleAdder = new DoubleAdder();
        doubleAdder.add(1);
        System.out.println(doubleAdder.intValue());
    }
}
