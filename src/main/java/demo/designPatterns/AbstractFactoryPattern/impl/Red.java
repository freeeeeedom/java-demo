package demo.designPatterns.AbstractFactoryPattern.impl;

import demo.designPatterns.Color;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}