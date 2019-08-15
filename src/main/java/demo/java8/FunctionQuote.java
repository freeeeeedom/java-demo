package demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FunctionQuote {
    static int num = 0;

    public static class Car {
        int num;

        public Car() {
            this.num = ++FunctionQuote.num;
        }

        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Car" + car.num + " Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Car" + this.num + " Following the " + another.num);
        }

        public void repair() {
            System.out.println("Car" + this.num + " Repaired " + this.toString());
        }
    }

    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        cars.forEach(Car::collide);

        cars.forEach(car1 -> Car.collide(car1));

        for (Car car1 : cars) {
            Car.collide(car1);
            car1.collide(car1);
        }

        cars.forEach(Car::repair);
        cars.forEach(car1 -> car1.repair());

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
        cars.forEach(car2 -> police.follow(car2));
        for (Car car2 : cars) {
            police.follow(car2);
        }
    }
}
