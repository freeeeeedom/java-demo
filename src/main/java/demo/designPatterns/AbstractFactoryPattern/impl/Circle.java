package demo.designPatterns.AbstractFactoryPattern.impl;

import demo.designPatterns.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}