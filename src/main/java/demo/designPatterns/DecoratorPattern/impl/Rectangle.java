package demo.designPatterns.DecoratorPattern.impl;

import demo.designPatterns.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}