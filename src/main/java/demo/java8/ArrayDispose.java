package demo.java8;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayDispose {
    public static void main(String[] args) {
        Integer[] arrayOfLong = new Integer[20000];
//        for (int i = 0; i < arrayOfLong.length; i++) {
//            arrayOfLong[i] = i;
//        }
//        System.out.println(System.currentTimeMillis() - start);
//
//        System.out.println("\n");
//        long sum = 0;
//        for (long l : arrayOfLong) {
//            sum += l;
//        }
//        System.out.println(sum);

        //获取一个有序的数组
//        AtomicInteger startPort = new AtomicInteger(20710);
//        long[] ports = new long[20];
//        Arrays.parallelSetAll(ports, value -> startPort.getAndIncrement());
//        Arrays.parallelSort(ports);
//        for (long port : ports) {
//            if (port % 5 == 0)
//                System.out.println(port);
//        }
//        System.out.println(ports);
//
//        //获取一个有序数组求和

//        System.out.println(arrayOfLong);
//        Random ran = new Random();
//        Arrays.parallelSetAll(arrayOfLong, value -> value);
//        Arrays.stream(arrayOfLong).forEach(
//                i -> System.out.println(i + " "));
//        System.out.println(Arrays.stream(arrayOfLong).parallel().reduce((left, right) -> left + right).getAsLong());

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            list.add(new User(i + "name", i + "pwd"));
        }
        List res = new CopyOnWriteArrayList();
        list.parallelStream().forEach(user -> res.add(user));
        System.out.println(list.size());

//        Arrays.parallelPrefix(arrayOfLong, (left, right) -> left + right);
//        System.out.println("\n");
//        Arrays.stream(arrayOfLong).forEach(
//                i -> System.out.print(i + " "));
//        System.out.println(arrayOfLong[arrayOfLong.length-1]);
//        parallelSum(20000);
    }

    static class User {
        String name;
        String pwd;

        public User(String name, String pwd) {
            this.name = name;
            this.pwd = pwd;
        }
    }

    public static void parallelSum(long n) {
        System.out.println(Stream.iterate(0L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum).longValue());
    }
}
