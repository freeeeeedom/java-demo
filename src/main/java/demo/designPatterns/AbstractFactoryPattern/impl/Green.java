package demo.designPatterns.AbstractFactoryPattern.impl;

import demo.designPatterns.Color;

public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}