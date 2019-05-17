package demo.designPatterns.PrototypePattern;

import demo.designPatterns.PrototypePattern.prototype.Circle;
import demo.designPatterns.PrototypePattern.prototype.Rectangle;
import demo.designPatterns.PrototypePattern.prototype.Shape;
import demo.designPatterns.PrototypePattern.prototype.Square;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("circel");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("square");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("rectangle");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}