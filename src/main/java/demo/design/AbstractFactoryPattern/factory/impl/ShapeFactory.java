package demo.design.AbstractFactoryPattern.factory.impl;

import demo.design.AbstractFactoryPattern.factory.AbstractFactory;
import demo.design.AbstractFactoryPattern.impl.Circle;
import demo.design.AbstractFactoryPattern.impl.Rectangle;
import demo.design.AbstractFactoryPattern.impl.Square;
import demo.design.Color;
import demo.design.Shape;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}