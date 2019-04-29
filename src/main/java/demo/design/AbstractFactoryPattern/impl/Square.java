package demo.design.AbstractFactoryPattern.impl;


import demo.design.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}