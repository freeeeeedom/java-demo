package demo.design.DecoratorPattern.impl;

import demo.design.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}