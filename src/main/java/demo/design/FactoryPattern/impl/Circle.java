package demo.design.FactoryPattern.impl;

import demo.design.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}