package demo.designPatterns.AbstractFactoryPattern.impl;

import demo.designPatterns.Color;

public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}