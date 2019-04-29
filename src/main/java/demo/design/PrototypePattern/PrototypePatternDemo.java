package demo.design.PrototypePattern;

import demo.design.PrototypePattern.prototype.Shape;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = ShapeCache.getShape("circel");
        System.out.println("Shape : " + clonedShape.getType());
        System.out.println("Shape clone: " + clonedShape.clone());
        System.out.println("Shape clone: " + clonedShape.clone());
        System.out.println("Shape clone: " + clonedShape.clone());

        Shape clonedShape2 = ShapeCache.getShape("square");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape("rectangle");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
