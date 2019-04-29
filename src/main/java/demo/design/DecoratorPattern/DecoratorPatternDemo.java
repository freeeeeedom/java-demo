package demo.design.DecoratorPattern;

import demo.design.DecoratorPattern.impl.Circle;
import demo.design.DecoratorPattern.impl.Rectangle;
import demo.design.DecoratorPattern.decorator.RedShapeDecorator;
import demo.design.Shape;

/**
 * @author Nevernow
 * @Description: 装饰器模式
 * @Date: 2019/4/26 14:27
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();

        StringBuilder sb = new StringBuilder();
        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}