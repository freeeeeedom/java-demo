package demo.design.AbstractFactoryPattern.factory.impl;

import demo.design.AbstractFactoryPattern.factory.AbstractFactory;
import demo.design.AbstractFactoryPattern.impl.Blue;
import demo.design.AbstractFactoryPattern.impl.Green;
import demo.design.AbstractFactoryPattern.impl.Red;
import demo.design.Color;
import demo.design.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
}