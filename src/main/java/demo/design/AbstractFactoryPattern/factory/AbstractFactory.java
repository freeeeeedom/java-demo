package demo.design.AbstractFactoryPattern.factory;

import demo.design.Color;
import demo.design.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
