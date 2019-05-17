package demo.design.AbstractFactoryPattern.factory;

import demo.design.AbstractFactoryPattern.factory.impl.ColorFactory;
import demo.design.AbstractFactoryPattern.factory.impl.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}