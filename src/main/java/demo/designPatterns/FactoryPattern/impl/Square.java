package demo.designPatterns.FactoryPattern.impl;


import demo.designPatterns.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}