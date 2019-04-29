package demo.design.DecoratorPattern.impl;

import demo.design.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}