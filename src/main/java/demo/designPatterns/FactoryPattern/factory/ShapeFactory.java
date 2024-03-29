package demo.designPatterns.FactoryPattern.factory;

import demo.designPatterns.FactoryPattern.impl.Circle;
import demo.designPatterns.FactoryPattern.impl.Rectangle;
import demo.designPatterns.FactoryPattern.impl.Square;
import demo.designPatterns.Shape;

public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
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

}

//public enum ShapeFactory {
//    CIRCLE, RECTANGLE, SQUARE;
//    private Shape shape = null;
//    public Shape getShape() {
//        if (shape != null) {
//            return shape;
//        }
//        switch (this.name()) {
//            case "CIRCLE":
//                shape = new Circle();
//                break;
//            case "RECTANGLE":
//                shape = new Rectangle();
//                break;
//            case "SQUARE":
//                shape = new Square();
//                break;
//        }
//        return shape;
//    }
//}