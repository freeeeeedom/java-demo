package demo.designPatterns.AbstractFactoryPattern.factory.impl;

import demo.designPatterns.AbstractFactoryPattern.factory.AbstractFactory;
import demo.designPatterns.AbstractFactoryPattern.impl.Blue;
import demo.designPatterns.AbstractFactoryPattern.impl.Green;
import demo.designPatterns.AbstractFactoryPattern.impl.Red;
import demo.designPatterns.Color;
import demo.designPatterns.Shape;

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