package demo.designPatterns.AbstractFactoryPattern.factory;

import demo.designPatterns.Color;
import demo.designPatterns.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
