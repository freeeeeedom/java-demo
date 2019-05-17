package demo.designPatterns.AbstractFactoryPattern.factory.impl;

import demo.designPatterns.AbstractFactoryPattern.factory.AbstractFactory;
import demo.designPatterns.AbstractFactoryPattern.impl.Circle;
import demo.designPatterns.AbstractFactoryPattern.impl.Rectangle;
import demo.designPatterns.AbstractFactoryPattern.impl.Square;
import demo.designPatterns.Color;
import demo.designPatterns.Shape;

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