package demo.designPatterns.DecoratorPattern.impl;

import demo.designPatterns.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}